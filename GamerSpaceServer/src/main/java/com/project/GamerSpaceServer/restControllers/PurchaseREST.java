package com.project.GamerSpaceServer.restControllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import com.project.GamerSpaceServer.dtos.ProductPurchaseDTO;
import com.project.GamerSpaceServer.dtos.PurchaseDTO;
import com.project.GamerSpaceServer.model.ProductPurchase;
import com.project.GamerSpaceServer.model.Purchase;
import com.project.GamerSpaceServer.services.IPurchaseService;
import com.project.GamerSpaceServer.utils.Constants;
import com.project.GamerSpaceServer.utils.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.solr.core.query.SolrPageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchases")
@RolesAllowed(Constants.ROLE_CUSTOMER)
public class PurchaseREST {
    @Autowired
    private IPurchaseService purchaseService;

    @GetMapping("cart/{id}/{page}/{size}")
    public Iterable<ProductPurchaseDTO> findAllProductsOnCar(@PathVariable("id") Long id, @PathVariable("page") int page, @PathVariable("size") int size){
        Pageable pageable = new SolrPageRequest(page, size, Sort.by(Direction.ASC, "title"));
        Page<ProductPurchase> products = purchaseService.findAllProductsOnCar(id, pageable);
        List<ProductPurchaseDTO> dtos = Converter.convertProductPurchaseListToDTO(products);
        return new PageImpl<>(dtos, pageable, products.getTotalElements());
    }

    @PostMapping("cart/{id}/add")
    public void addProductPurchaseToCar(@PathVariable Long id, @RequestBody ProductPurchase productPurchase){
        purchaseService.addProductPurchaseToCar(productPurchase, id);
    }

    @DeleteMapping("cart/{id}/delete/{productId}/{page}/{size}")
    public Iterable<ProductPurchaseDTO> deleteProductPurchaseFromCar(@PathVariable("id") Long id, @PathVariable("productId") Long productId, @PathVariable("page") int page, @PathVariable("size") int size){
        Pageable pageable = new SolrPageRequest(page, size, Sort.by(Direction.ASC, "title"));
        Page<ProductPurchase> products = purchaseService.deleteProductPurchaseFromCar(productId, id, pageable);
        List<ProductPurchaseDTO> dtos = Converter.convertProductPurchaseListToDTO(products);
        return new PageImpl<>(dtos, pageable, products.getTotalElements());
    }

    @PostMapping("pay/{id}")
    public void payPurchase(@RequestBody Purchase purchase, @PathVariable Long id){
        purchaseService.createPurchase(purchase, id);
    }

    @GetMapping("list/{id}/{page}/{size}")
    public Iterable<PurchaseDTO> findAllCustomerPurchases(@PathVariable("id") Long id, @PathVariable("page") int page, @PathVariable("size") int size){
        Pageable pageable = new SolrPageRequest(page, size, Sort.by(Direction.ASC, "date"));
        Page<Purchase> purchases = purchaseService.findAllCustomerPurchases(id, pageable);
        List<PurchaseDTO> dtos = Converter.convertPurchaseListToDTO(purchases);
        return new PageImpl<>(dtos, pageable, purchases.getTotalElements());
    }

    @GetMapping("list/details/{id}/{page}/{size}")
    public Iterable<ProductPurchaseDTO> findAllPurchaseDetails(@PathVariable("id") Long id, @PathVariable("page") int page, @PathVariable("size") int size){
        Pageable pageable = new SolrPageRequest(page, size, Sort.by(Direction.ASC, "title"));
        Page<ProductPurchase> products = purchaseService.findAllPurchaseDetails(id, pageable);
        List<ProductPurchaseDTO> dtos = Converter.convertProductPurchaseListToDTO(products);
        return new PageImpl<>(dtos, pageable, products.getTotalElements());
    }
}
