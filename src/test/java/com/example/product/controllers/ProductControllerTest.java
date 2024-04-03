package com.example.product.controllers;

import com.example.product.models.Product;
import com.example.product.services.IProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductControllerTest {


    @Autowired
    private ProductController productController;

    @MockBean
    @Qualifier("fakeStoreProductService")
    private IProductService productService;

    @Test
    void getAllProducts() {
        Product p1=new Product();
        Product p2=new Product();
        Product p3=new Product();
        List<Product> mockedResponse=Arrays.asList(p1,p2,p3);
        Mockito.when(productService.getAllProducts())
                .thenReturn(mockedResponse);
       List<Product> allProducts=productController.getAllProducts();
        Assertions.assertEquals(3,allProducts.size());
    }
}