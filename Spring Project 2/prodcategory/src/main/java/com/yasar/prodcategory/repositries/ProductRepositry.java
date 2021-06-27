package com.yasar.prodcategory.repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yasar.prodcategory.models.Category;
import com.yasar.prodcategory.models.Product;

@Repository
public interface ProductRepositry extends CrudRepository<Product, Long>{
    List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}

