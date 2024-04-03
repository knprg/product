package com.example.product.repositories;

import com.example.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);

    //HQL Query
    @Query("select p from Product p where p.id = :id")
    Product something(@Param("id") Long id);

    @Query("select p.id as id,p.name as name,p.price as price from Product p where p.id=:id")
    ProductWithIdNamePrice somethingSpecific(@Param("id") Long id);
    @Query(value="select * from product where id=:id" , nativeQuery = true)
    Product somethingMySqlQuery(@Param("id") Long id);

    @Query(value="select id,name,price from product where id=:id" , nativeQuery = true)
    ProductWithIdNamePrice somethingMySqlQuerySpec(@Param("id") Long id);


}
