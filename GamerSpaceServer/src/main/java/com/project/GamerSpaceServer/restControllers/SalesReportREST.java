package com.project.GamerSpaceServer.restControllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import com.project.GamerSpaceServer.dtos.PurchaseDTO;
import com.project.GamerSpaceServer.dtos.StatisticsDTO;
import com.project.GamerSpaceServer.model.Purchase;
import com.project.GamerSpaceServer.services.ISalesReportService;
import com.project.GamerSpaceServer.utils.Constants;
import com.project.GamerSpaceServer.utils.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.solr.core.query.SolrPageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("report")
@RolesAllowed(Constants.ROLE_ADMIN)
public class SalesReportREST {
    @Autowired
    private ISalesReportService reportService;

    @GetMapping("{page}/{size}/{filter}")
    public Page<PurchaseDTO> findAllPurchases(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("filter") String filter){
        Pageable pageable = new SolrPageRequest(page, size, Sort.by(Direction.ASC, filter));
        Page<Purchase> purchases = reportService.findAllPurchases(pageable);
        List<PurchaseDTO> dtos = Converter.convertPurchaseListToDTO(purchases);
        return new PageImpl<>(dtos, pageable, purchases.getTotalElements());
    }

    @GetMapping("{page}/{size}/{filter}/{name}")
    public Page<PurchaseDTO> findPurchasesByCustomer(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("filter") String filter, @PathVariable("name") String name){
        Pageable pageable = new SolrPageRequest(page, size, Sort.by(Direction.ASC, filter));
        Page<Purchase> purchases = reportService.findPurchasesByCustomer(name, pageable);
        List<PurchaseDTO> dtos = Converter.convertPurchaseListToDTO(purchases);
        return new PageImpl<>(dtos, pageable, purchases.getTotalElements());
    }

    @GetMapping("statistics")
    public StatisticsDTO findStatistics(){
        StatisticsDTO statistics = new StatisticsDTO();
        statistics.setEarnings(reportService.getEarnings());
        statistics.setProductsStock(reportService.getProductsInStock());
        statistics.setSoldProducts(reportService.getSoldProductsAmount());
        statistics.setTotalPurchases(reportService.getTotalPurchases());
        return statistics;
    }
}
