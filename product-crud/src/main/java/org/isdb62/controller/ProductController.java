package org.isdb62.controller;

import java.util.List;

import org.isdb62.model.Product;
import org.isdb62.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		return productService.getProductById(id);
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
//		productService.saveProduct(product);
		return productService.saveAndRetrieve(product);
	}

	@PutMapping("/{id}")
	public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		product.setId(id);
		productService.updateProduct(product);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
	}
}