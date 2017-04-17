package br.com.ac.avenue.dao;

import java.util.List;

import br.com.ac.avenue.model.Product;

public interface ProductDAO {

	 Product save(Product product);
	 
	 void update(Product product);
	 
	 void delete(Product product);
	 
	 Product findProduct(Integer id);
	 
	 List<Product> getAllProducts();
}