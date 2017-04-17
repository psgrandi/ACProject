package br.com.ac.avenue.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.ac.avenue.model.Image;
import br.com.ac.avenue.model.Product;

/**
 * Repository that execute CRUD operations on Image entity
 * @author psilveira
 *
 */
@Repository
public class ImageDAOImpl implements ImageDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void save(Image image) {
		manager.persist(image);
	}

	@Override
	public void update(Image image) {
		manager.merge(image);
	}

	@Override
	public void delete(Image image) {
		manager.remove(manager.getReference(Image.class, image.getImageId()));		
	}
	
	@Override
	public Image findImage(Integer id) {
		return manager.find(Image.class, id);
	}
	
	@Override
	public void deleteProductImages(Product product) {
		Query query = manager.createQuery("DELETE FROM Image I WHERE I.product = :product");
		query.setParameter("product", product).executeUpdate();
	}
}
