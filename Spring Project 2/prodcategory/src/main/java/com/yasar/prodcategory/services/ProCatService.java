package com.yasar.prodcategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yasar.prodcategory.models.Category;
import com.yasar.prodcategory.models.Product;
import com.yasar.prodcategory.repositries.CategoryRepositry;
import com.yasar.prodcategory.repositries.ProductRepositry;

@Service
public class ProCatService {
	private final CategoryRepositry catRepo;
	private final ProductRepositry proRepo;
    public ProCatService(CategoryRepositry catRepo, ProductRepositry proRepo) {
        this.catRepo = catRepo;
        this.proRepo = proRepo;
    }

	public List<Product> allProducts(){
		return proRepo.findAll();
	}
	public List<Category> allCategorys(){
		return catRepo.findAll();
	}
	public void creatProduct(Product p) {
		proRepo.save(p);
	}
	public void creatCategory(Category c) {
		catRepo.save(c);
	}
	public List<Product> getCategoriesNotContains(Long id){
		Category c= getCategory(id);

		return proRepo.findByCategoriesNotContains(c);
	}
	public List<Category> getProductsNotContains(Long id){
		Product p= getProduct(id);

		return catRepo.findByProductsNotContains(p);
	}
	public Product getProduct(Long id) {
		return 	proRepo.findById(id).orElse(null);

		
	}
	public Category getCategory(Long id) {
		return 	catRepo.findById(id).orElse(null);

	}
	public List<Category> getProductCategories(Long id){
		Product p= getProduct(id);
		return p.getCategories();
	}
	public List<Product> getCategoryProducts(Long id){
		Category c= getCategory(id);
		return c.getProducts();
	}
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = catRepo.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = proRepo.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
    public void addProduct(Long id, Category c) {
    	List<Product> lp = c.getProducts();
    	Product p = findProduct(id);
    	lp.add(p);
    	c.setProducts(lp);
		catRepo.save(c);
    }
    public void addCategory(Long id, Product p) {
    	List<Category> lc = p.getCategories();
    	Category c = findCategory(id);
    	lc.add(c);
    	p.setCategories(lc);
    	proRepo.save(p);
    }


}
