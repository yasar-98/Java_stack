package com.yasar.prodcategory.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yasar.prodcategory.models.Category;
import com.yasar.prodcategory.models.Product;
import com.yasar.prodcategory.services.ProCatService;

@Controller
public class ProCatController {
	private final ProCatService proCatService;
    public ProCatController(ProCatService proCatService) {
        this.proCatService = proCatService;
    }

	@RequestMapping("/products/new")
		public String Product(@ModelAttribute("product") Product product) {
			return "product.jsp";
		}
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult results) {
		if(results.hasErrors()) {
			return "product.jsp";
		}
		proCatService.creatProduct(product);
		return "redirect:/products/new";
	}
	@RequestMapping("/categories/new")
	public String Category(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult results) {
		if(results.hasErrors()) {
			return "category.jsp";
		}
		proCatService.creatCategory(category);
		return "redirect:/categories/new";
	}
	@RequestMapping("/products/{id}")
	public String productShow(@PathVariable("id") Long id, Model model) {
		Product product = proCatService.findProduct(id);
        model.addAttribute("product", product);
		model.addAttribute("allProductCat", proCatService.getProductCategories(id));
		model.addAttribute("allNotCat", proCatService.getProductsNotContains(id));
		return "productD.jsp";
	}
	@PostMapping("/products/{id}")
	public String categoryAdd(@PathVariable("id") Long id, @RequestParam(value="product") Long idc) {
		Product product = proCatService.findProduct(id);
		proCatService.addCategory(idc, product);
		return "redirect:/products/{id}";
	}

	@RequestMapping("/categories/{id}")
	public String categoryShow(@PathVariable("id") Long id, Model model) {
		Category category = proCatService.findCategory(id);
        model.addAttribute("category", category);
		model.addAttribute("allCategoryPro", proCatService.getCategoryProducts(id));
				model.addAttribute("allNotPro", proCatService.getCategoriesNotContains(id));
		return "catD.jsp";
	}
	@PostMapping("/categories/{id}")
	public String productAdd(@PathVariable("id") Long id, @RequestParam(value="category") Long idp) {
		Category category = proCatService.findCategory(id);
		proCatService.addProduct(idp, category);
		return "redirect:/categories/{id}";
	}



}
