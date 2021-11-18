package com.project.GamerSpaceServer.services;

import com.project.GamerSpaceServer.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Product findProductById(Long id);
    public Page<Product> findAllProducts(Pageable pageable);
    public Page<Product> deleteProduct(Long id, Pageable pageable);
    public int getProductsInStock();
}
