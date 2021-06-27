package com.yasar.prodcategory.repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yasar.prodcategory.models.Category;
import com.yasar.prodcategory.models.Product;

@Repository
public interface CategoryRepositry extends CrudRepository<Category, Long> {

    List<Category> findAll();

	List<Category> findByProductsNotContains(Product product);

}