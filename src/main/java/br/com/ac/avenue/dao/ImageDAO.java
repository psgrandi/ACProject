package br.com.ac.avenue.dao;

import br.com.ac.avenue.model.Image;
import br.com.ac.avenue.model.Product;

public interface ImageDAO {
	
	 void save(Image image);
	 
	 void update(Image image);
	 
	 void delete(Image image);
	 
	 Image findImage(Integer id);

	 void deleteProductImages(Product product);
}
