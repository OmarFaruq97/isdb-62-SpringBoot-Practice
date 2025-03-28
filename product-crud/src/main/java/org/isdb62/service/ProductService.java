package org.isdb62.service;

import java.util.List;
import org.isdb62.model.Product;
import org.isdb62.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id);
	}

	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	public Product saveAndRetrieve(Product product) {
		return productRepository.saveAndRetrieve(product);
	}

	public void updateProduct(Product product) {
		productRepository.update(product);
	}

	public Product updateProductAndRetrieve(Product product) {
		return productRepository.updateAndRetrieve(product);
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
