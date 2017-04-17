package br.com.ac.avenue.service;

import java.util.List;
import java.util.Set;

import javax.ws.rs.WebApplicationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ac.avenue.dao.ImageDAO;
import br.com.ac.avenue.dao.ProductDAO;
import br.com.ac.avenue.model.Image;
import br.com.ac.avenue.model.Product;

/**
 * Service bean that contains business logic for API and CRUD services
 * @author psilveira
 *
 */
@Service
@Transactional
public class AvenueServiceImpl implements AvenueService {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ImageDAO imageDAO;
	
	@Override
	public void createProduct(Product product) {
		productDAO.save(product);
		
		if (product.getImages() != null) {
			for (Image image : product.getImages()) {
				image.setProduct(product);
				createImage(image);
			}
		}
	}

	@Override
	public void updateProduct(Product product) {
		if (findProduct(product.getProductId()) != null) {		
			productDAO.update(product);
			
			if (product.getImages() != null) {
				for (Image image : product.getImages()) {
					image.setProduct(product);
					updateImage(image);
				}
			}
		} else {			
			throw new WebApplicationException("Product not found!");
		}
	}

	@Override
	public void deleteProduct(Integer id) {
		Product product = findProduct(id);
		
		if (product != null) {		
			productDAO.delete(product);
		} else {			
			throw new WebApplicationException("Product not found!");
		}
	}
	
	@Override
	public void createImage(Image image) {
		imageDAO.save(image);
	}
	
	@Override
	public void createImage(Integer productId, Image image) {
		Product product = findProduct(productId);
		
		if (product != null) {
			image.setProduct(product);
			imageDAO.save(image);
		} else {			
			throw new WebApplicationException("Product not found!");
		}
	}
	
	@Override
	public void updateImage(Image image) {
		if (findImage(image.getImageId()) != null) {		
			imageDAO.update(image);
		} else {			
			throw new WebApplicationException("Image not found!");
		}
	}
	
	@Override
	public void deleteImage(Integer id) {
		Image image = findImage(id);
		
		if (image != null) {		
			imageDAO.delete(image);
		} else {			
			throw new WebApplicationException("Image not found!");
		}
	}
	
	@Override
	public Product findProduct(Integer id) {
		return productDAO.findProduct(id);
	}
	
	@Override
	public Image findImage(Integer id) {
		return imageDAO.findImage(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	@Override
	public Product getProductById(Integer id) {
		return productDAO.findProduct(id);
	}
	
	@Override
	public Set<Product> getChildrenByParentId(Integer id) {
		return productDAO.findProduct(id).getChildren();
	}
	
	@Override
	public Set<Image> getImagesByProductId(Integer id) {
		return productDAO.findProduct(id).getImages();
	}	
}
