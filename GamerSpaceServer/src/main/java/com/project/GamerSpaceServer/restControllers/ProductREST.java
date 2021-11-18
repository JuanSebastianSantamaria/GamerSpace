package com.project.GamerSpaceServer.restControllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import com.project.GamerSpaceServer.dtos.ProductDTO;
import com.project.GamerSpaceServer.model.Product;
import com.project.GamerSpaceServer.services.IProductService;
import com.project.GamerSpaceServer.utils.Constants;
import com.project.GamerSpaceServer.utils.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.solr.core.query.SolrPageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@RolesAllowed(Constants.ROLE_ADMIN)
public class ProductREST {
    @Autowired
    private IProductService productService;

    @RolesAllowed({Constants.ROLE_ADMIN, Constants.ROLE_CUSTOMER})
    @GetMapping("list/{page}/{size}")
    public Iterable<ProductDTO> findAllProducts(@PathVariable("page") int page, @PathVariable("size") int size){
        Pageable pageable = new SolrPageRequest(page, size, Sort.by(Direction.ASC, "title"));
        Page<Product> products = productService.findAllProducts(pageable);
        List<ProductDTO> dtos = Converter.convertProductListToDTO(products);
        return new PageImpl<>(dtos, pageable, products.getTotalElements());
    }

    @RolesAllowed({Constants.ROLE_ADMIN, Constants.ROLE_CUSTOMER})
    @GetMapping("{id}")
    public ProductDTO findProductById(@PathVariable Long id){
        return Converter.convertProductToDTO(productService.findProductById(id));
    }

    @PostMapping("new")
    public ProductDTO createProduct(@RequestBody Product product){
        return Converter.convertProductToDTO(productService.createProduct(product));
    }

    @PutMapping("update")
    public ProductDTO updateProduct(@RequestBody Product product){
        return Converter.convertProductToDTO(productService.updateProduct(product));
    }

    @DeleteMapping("delete/{page}/{size}/{id}")
    public Iterable<ProductDTO> deleteProduct(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("id") Long id){
        Pageable pageable = new SolrPageRequest(page, size, Sort.by(Direction.ASC, "title"));
        Page<Product> products = productService.deleteProduct(id, pageable);
        List<ProductDTO> dtos = Converter.convertProductListToDTO(products);
        return new PageImpl<>(dtos, pageable, products.getTotalElements());
    }
}
