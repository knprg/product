package com.example.product.services;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.exceptions.InvalidProductIdException;
import com.example.product.exceptions.ProducDoesNotExistException;
import com.example.product.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    Product getSingleProduct(Long id) throws InvalidProductIdException;

    List<Product> getAllProducts();

    Product addproduct(Product product);

    Product updateProduct(Long id, Product product) throws ProducDoesNotExistException;
    void deleteProduct(Long id);
}
