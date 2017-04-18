package br.com.ac.avenue.controller;

import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.ac.avenue.model.Image;
import br.com.ac.avenue.model.Product;
import br.com.ac.avenue.service.AvenueService;


/**
 * Controller that receives requests for api methods and return as json file
 * @author psilveira
 *
 */
@Path("/api")
@Produces("application/json")
public class AvenueController {
	
	@Autowired
	private AvenueService avenueService;
	
	/**
	 * Get all products excluding relationships (child products, images)
	 * @return List of Products
	 * @throws JsonProcessingException
	 */
	@GET
	@Path("/product/getProducts")
	public Response getAllProducts() throws JsonProcessingException {
		List<Product> products = avenueService.getAllProducts();
				
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonToSend = gson.toJson(products);

		return Response.ok(new GenericEntity<String>(jsonToSend){}).build();
	}
	
	/**
	 * Get product by id excluding relationships (child products, images)
	 * @return id
	 * @return Product
	 */
	@GET
	@Path("/product/getProducts/{id}")
	public Response getAllProducts(@PathParam("id") Integer id) {
		Product product = avenueService.getProductById(id);

		if (product == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonToSend = gson.toJson(product);
		
        return Response.ok(jsonToSend).build();
	}	
	
	/**
	 * Get all products including specified relationships (child product and/or images)
	 * @return List of Products
	 * @throws JsonProcessingException
	 */
	@GET
	@Path("/product/getCompleteProducts")
	public Response getCompleteProducts() throws JsonProcessingException {
		List<Product> products = avenueService.getAllProducts();
				
		return Response.ok(new GenericEntity<List<Product>>(products){}).build();
	}
	
	/**
	 * Get product by id including specified relationships (child product and/or images)
	 * @param id
	 * @return Product
	 */
	@GET
	@Path("/product/getCompleteProducts/{id}")
	public Response getCompleteProductsById(@PathParam("id") Integer id) {
		Product product = avenueService.getProductById(id);
		
		if (product == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
		
        return Response.ok(new GenericEntity<Product>(product){}).build();
	}	
	
	/**
	 * Get set of child products for specific product
	 * @param id
	 * @return Set of products
	 */
	@GET
	@Path("/product/{id}/getChildren")
	public Response getChildrenByParentId(@PathParam("id") Integer id) {
		Set<Product> products = avenueService.getChildrenByParentId(id);
		
		if ((products == null) || (products.isEmpty())) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
		
        return Response.ok(new GenericEntity<Set<Product>>(products){}).build();
	}	
	
	/**
	 * Get set of images for specific product
	 * @param id
	 * @return Set of Images
	 */
	@GET
	@Path("/product/{id}/getImages")
	public Response getImagesByProductId(@PathParam("id") Integer id) {
		Set<Image> images = avenueService.getImagesByProductId(id);
		
		if ((images == null) || (images.isEmpty())) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
		
        return Response.ok(new GenericEntity<Set<Image>>(images){}).build();
	}		
}
