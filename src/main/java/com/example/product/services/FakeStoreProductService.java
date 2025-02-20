package com.example.product.services;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.dtos.ProductResponseDto;
import com.example.product.exceptions.InvalidProductIdException;
import com.example.product.models.Category;
import com.example.product.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.http.HttpMethod;
import java.util.ArrayList;
import java.util.List;

@Service
//@Primary
@Qualifier("fakeStoreProductService")
public class FakeStoreProductService implements IProductService{
    @Autowired
    RestTemplate restTemplate;
    public Product getProductFromResponseDto(ProductResponseDto responseDto){
        Product product = new Product();
        product.setId(responseDto.getId());
        product.setName(responseDto.getTitle());
        product.setPrice(responseDto.getPrice());
        product.setDescription(responseDto.getDescription());
        product.setImage(responseDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(responseDto.getCategory());
        return product;
    }
    @Override
    public Product getSingleProduct(Long id) throws InvalidProductIdException {

        // pass this id to fakestore and get the details of this product
        // https://fakestoreapi.com/products/1
        if(id>20){
            throw new InvalidProductIdException("product not found");
        }

        ProductResponseDto response = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductResponseDto.class);

        return getProductFromResponseDto(response);
    }

    @Override
    public List<Product> getAllProducts() {
        ProductResponseDto[] responseDtoList = restTemplate.getForObject("https://fakestoreapi.com/products/", ProductResponseDto[].class);
        List<Product> output=new ArrayList<>();
        for(ProductResponseDto productResponseDto: responseDtoList){
            output.add(getProductFromResponseDto(productResponseDto));
        }
        return output;
    }

    @Override
    public Product addproduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    //@Override
    //public Product updateProduct(Long id, ProductRequestDto productRequestDto) {

        //RequestCallback requestCallback = restTemplate.httpEntityCallback(productRequestDto, ProductResponseDto.class);
        //HttpMessageConverterExtractor<ProductResponseDto> responseExtractor =
            //    new HttpMessageConverterExtractor<>(ProductResponseDto.class,
          //              restTemplate.getMessageConverters());
        //ProductResponseDto responseDto = restTemplate.execute("https://fakestoreapi.com/products/" + id,
          //      HttpMethod.PUT, requestCallback, responseExtractor);
        //return getProductFromResponseDto(responseDto);

   // }
}
