import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Purchase } from 'src/app/model/purchase';
import { StatisticsDTO } from 'src/app/model/statistics-dto';
import { ReportsService } from 'src/app/services/reports.service';

@Component({
  selector: 'app-sales-report',
  templateUrl: './sales-report.component.html',
  styleUrls: ['./sales-report.component.css']
})
export class SalesReportComponent implements OnInit {
  purchases: Array<Purchase> = [];
  totalPages: Array<number> = [];
  size: number = 10;
  page: number = 0;
  filter: string = 'purchaseId';
  buyer: string = '';

  statistics: StatisticsDTO = new StatisticsDTO(0, 0, 0, 0);
  soldProductsPercent: number = 0;
  productsStockPercent: number = 0;

  constructor(
    private reportsService: ReportsService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.page = 0;
    this.findReport(this.page, this.size);
    this.calculateStatistics();
  }

  findReport(page: number, size: number){
    this.route.paramMap
      .pipe(switchMap( 
        params => this.reportsService.getPurchasesReport(page, size, this.filter)
        ))
      .subscribe(pageResponse => {
        this.totalPages = [];
        for (let i = 1; i <= Math.ceil(pageResponse.totalElements / this.size); i++) {
          this.totalPages.push(i);
        }
        this.purchases = pageResponse.content;
      });
  }

  findByBuyer(page: number, size: number){
    this.route.paramMap
      .pipe(switchMap( 
        params => this.reportsService.getPurchasesByCustomerName(page, size, this.buyer, this.filter)
        ))
      .subscribe(pageResponse => {
        this.totalPages = [];
        for (let i = 1; i <= Math.ceil(pageResponse.totalElements / this.size); i++) {
          this.totalPages.push(i);
        }
        this.purchases = pageResponse.content;
      });
  }

  calculateStatistics(){
    this.route.paramMap
      .pipe(switchMap( 
        params => this.reportsService.getStatistics()
        ))
      .subscribe(statistics => {
        this.statistics = statistics;
        // Calculate sold products percentage
        this.soldProductsPercent = (this.statistics.soldProducts + this.statistics.productsStock) == 0?
          0 : 
          (this.statistics.soldProducts*100) / (this.statistics.soldProducts + this.statistics.productsStock);
        // Calculate products in stock percentage
        this.productsStockPercent = (this.statistics.soldProducts + this.statistics.productsStock) == 0? 
          0 : 
          (this.statistics.productsStock*100) / (this.statistics.soldProducts + this.statistics.productsStock);
      });
  }

  changeFilter(filter: string){
    this.filter = filter;
    this.findReport(this.page, this.size);
  }

  search(){
    this.findByBuyer(this.page, this.size);
  }

  changePage(change: number, numberClicked: boolean){
    if(numberClicked){
      this.page = change - 1;
      this.findReport(this.page, this.size);
    } else{
      if(this.page + change >= 0 && this.page + change < this.totalPages.length){
        this.page = this.page + change;
        this.findReport(this.page, this.size);
      }
    }
  }
}
