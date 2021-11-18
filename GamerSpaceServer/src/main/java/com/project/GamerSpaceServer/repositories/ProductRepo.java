package com.project.GamerSpaceServer.repositories;
import com.project.GamerSpaceServer.model.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepo extends PagingAndSortingRepository<Product, Long> {
    @Query("SELECT SUM(p.stock) FROM Product p")
    int getProductsInStock();
}
