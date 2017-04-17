package br.com.ac.avenue.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ac.avenue.model.Product;

/**
 * Repository that execute CRUD operations on Product entity
 * @author psilveira
 *
 */
@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Product save(Product product) {
		manager.persist(product);
		manager.flush();
		
		return product;
	}

	@Override
	public void update(Product product) {
		manager.merge(product);
	}

	@Override
	public void delete(Product product) {
		manager.remove(manager.getReference(Product.class, product.getProductId()));
	}
	
	@Override
	public Product findProduct(Integer id) {
		return manager.find(Product.class, id);
	}
	
	public List<Product> getAllProducts() {
		return manager.createQuery("SELECT P FROM Product P", Product.class).getResultList();
	}
}
