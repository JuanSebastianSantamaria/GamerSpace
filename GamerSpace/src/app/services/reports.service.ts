import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Page } from '../model/page';
import { Purchase } from '../model/purchase';
import { StatisticsDTO } from '../model/statistics-dto';
import { RestService } from './shared/rest.service';

@Injectable({
  providedIn: 'root'
})
export class ReportsService {

  constructor(
    private restService: RestService
  ) { }

  getPurchasesReport(page: number, size: number, filter: string) {
    const url = `${environment.globalURL}/report/${page}/${size}/${filter}`;
    return this.restService.get<Page>(url);
  }

  getPurchasesByCustomerName(page: number, size: number, name: string, filter: string) {
    const url = `${environment.globalURL}/report/${page}/${size}/${filter}/${name}`;
    return this.restService.get<Page>(url);
  }

  getStatistics(){
    const url = `${environment.globalURL}/report/statistics`;
    return this.restService.get<StatisticsDTO>(url);
  }
}
