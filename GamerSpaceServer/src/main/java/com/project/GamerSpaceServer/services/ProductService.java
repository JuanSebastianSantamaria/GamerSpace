package com.project.GamerSpaceServer.services;

import com.project.GamerSpaceServer.model.Product;
import com.project.GamerSpaceServer.repositories.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product editedProduct = findProductById(product.getProductId());
        editedProduct.setTitle(product.getTitle());
        editedProduct.setDescription(product.getDescription());
        editedProduct.setPrice(product.getPrice());
        editedProduct.setStock(product.getStock());
        editedProduct.setPhotoPath(product.getPhotoPath());
        return productRepo.save(editedProduct);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Page<Product> findAllProducts(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public Page<Product> deleteProduct(Long id, Pageable pageable) {
        if(productRepo.existsById(id)){
            productRepo.deleteById(id);
        }
        return productRepo.findAll(pageable);
    }

    @Override
    public int getProductsInStock() {
        return productRepo.getProductsInStock();
    }
    
}
