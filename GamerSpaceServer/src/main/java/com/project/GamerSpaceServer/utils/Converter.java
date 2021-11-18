package com.project.GamerSpaceServer.utils;

import java.util.ArrayList;
import java.util.List;

import com.project.GamerSpaceServer.dtos.AdminDTO;
import com.project.GamerSpaceServer.dtos.CustomerDTO;
import com.project.GamerSpaceServer.dtos.ProductDTO;
import com.project.GamerSpaceServer.dtos.ProductPurchaseDTO;
import com.project.GamerSpaceServer.dtos.PurchaseCarDTO;
import com.project.GamerSpaceServer.dtos.PurchaseDTO;
import com.project.GamerSpaceServer.model.Admin;
import com.project.GamerSpaceServer.model.Customer;
import com.project.GamerSpaceServer.model.Product;
import com.project.GamerSpaceServer.model.ProductPurchase;
import com.project.GamerSpaceServer.model.Purchase;
import com.project.GamerSpaceServer.model.PurchaseCar;

import org.modelmapper.ModelMapper;

public class Converter {

    public static List<ProductDTO> convertProductListToDTO(Iterable<Product> products){
        ArrayList<ProductDTO> productsDTO = new ArrayList<ProductDTO>();
        for (Product p : products) {
            productsDTO.add(convertProductToDTO(p));
        }
        return productsDTO;
    }

    public static ProductDTO convertProductToDTO(Product product){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(product, ProductDTO.class);
    }

    public static List<PurchaseDTO> convertPurchaseListToDTO(Iterable<Purchase> purchases){
        ArrayList<PurchaseDTO> purchaseDTOs = new ArrayList<PurchaseDTO>();
        for (Purchase p : purchases) {
            purchaseDTOs.add(convertPurchaseToDTO(p));
        }
        return purchaseDTOs;
    }

    public static PurchaseDTO convertPurchaseToDTO(Purchase purchase){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(purchase, PurchaseDTO.class);
    }

    public static CustomerDTO convertCustomerToDTO(Customer customer){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(customer, CustomerDTO.class);
    }

    public static AdminDTO convertAdminToDTO(Admin admin){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(admin, AdminDTO.class);
    }

    public static List<ProductPurchaseDTO> convertProductPurchaseListToDTO(Iterable<ProductPurchase> products){
        ArrayList<ProductPurchaseDTO> productsDTO = new ArrayList<ProductPurchaseDTO>();
        for (ProductPurchase p : products) {
            productsDTO.add(convertProductPurchaseToDTO(p));
        }
        return productsDTO;
    }

    public static ProductPurchaseDTO convertProductPurchaseToDTO(ProductPurchase product){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(product, ProductPurchaseDTO.class);
    }

    public static PurchaseCarDTO convertPurchaseCarToDTO(PurchaseCar purchaseCar){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(purchaseCar, PurchaseCarDTO.class);
    }
}
