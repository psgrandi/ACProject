package br.com.ac.avenue.service;

import java.util.List;
import java.util.Set;

import br.com.ac.avenue.model.Image;
import br.com.ac.avenue.model.Product;

public interface AvenueService {
	
	void createProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(Integer id);
	
	void createImage(Image image);
	
	void createImage(Integer productId, Image image);
	
	void updateImage(Image image);
	
	void deleteImage(Integer id);	
	
	Product findProduct(Integer id);
	
	Image findImage(Integer id);
	
	List<Product> getAllProducts();
	
	Product getProductById(Integer id);
	
	Set<Product> getChildrenByParentId(Integer id);
	
	Set<Image> getImagesByProductId(Integer id);

}
