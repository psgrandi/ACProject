package br.com.ac.avenue.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ac.avenue.model.Image;
import br.com.ac.avenue.model.Product;
import br.com.ac.avenue.service.AvenueService;

/**
 * Controller that receives requests for CRUD methods
 * @author psilveira
 *
 */
@Path("/crud")
public class CRUDController {
	
	@Autowired
	private AvenueService avenueService;
	
	/**
	 * Add new Product
	 * @param product
	 * @return Response Status
	 */
	@POST
	@Path("/product/add")
	@Consumes("application/json")
	public Response addProduct(Product product) {
		try {
			avenueService.createProduct(product);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return Response.serverError().build();
		}
		
		return Response.ok().build();
	}
	
	/**
	 * Add new product as child of another product
	 * @param id Parent Product ID
	 * @param child
	 * @return Response Status
	 */
	@POST
	@Path("/product/{id}/addChild")
	@Consumes("application/json")
	public Response addProduct(@PathParam("id") Integer id, Product child) {
		Product parent = avenueService.findProduct(id);
		
		if (parent != null) {
			try {
				child.setParent(parent);
				avenueService.createProduct(child);
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				return Response.serverError().build();
			}
			
			return Response.ok().build();
		} else {			
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}	
	
	/**
	 * Add Image to a product
	 * @param id Parent ProductID
	 * @param image
	 * @return Response Status
	 */
	@POST
	@Path("/product/{id}/image/add")
	@Consumes("application/json")
	public Response addImage(@PathParam("id") Integer id, Image image) {
		
		if (avenueService.findProduct(id) != null) {
			try {
				avenueService.updateImage(image);
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				return Response.serverError().build();
			}
			
			return Response.ok().build();
		} else {			
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}	
	
	/**
	 * Update product by ID
	 * @param id
	 * @param product
	 * @return Response Status
	 */
	@PUT
	@Path("/product/update/{id}")
	@Consumes("application/json")
	public Response updateProduct(@PathParam("id") Integer id, Product product) {
		try {
			product.setProductId(id);
			avenueService.updateProduct(product);
			
		} catch (WebApplicationException e) {
			System.out.println("Error: " + e.getMessage());
			return Response.status(Response.Status.NOT_FOUND).build();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return Response.serverError().build();
		}
		
		return Response.ok().build();
	}
	
	/**
	 * Update image by ID
	 * @param id
	 * @param image
	 * @return Response Status
	 */
	@PUT
	@Path("/image/update/{id}")
	@Consumes("application/json")
	public Response updateImage(@PathParam("id") Integer id, Image image) {
		
		try {
			image.setImageId(id);
			avenueService.updateImage(image);
			
		} catch (WebApplicationException e) {
			System.out.println("Error: " + e.getMessage());
			return Response.status(Response.Status.NOT_FOUND).build();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return Response.serverError().build();
		}
		
		return Response.ok().build();
	}
	
	/**
	 * DElete product by ID
	 * @param id
	 * @return Response Status
	 */
	@DELETE
	@Path("/product/delete/{id}")
	public Response deleteProduct(@PathParam("id") Integer id) {
		try {
			avenueService.deleteProduct(id);
			
		} catch (WebApplicationException e) {
			System.out.println("Error: " + e.getMessage());
			return Response.status(Response.Status.NOT_FOUND).build();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return Response.serverError().build();
		}
		
		return Response.ok().build();
	}	
	
	/**
	 * Delete Image by ID
	 * @param id
	 * @return Response Status
	 */
	@DELETE
	@Path("/image/delete/{id}")
	public Response deleteImage(@PathParam("id") Integer id) {
		try {
			avenueService.deleteImage(id);
			
		} catch (WebApplicationException e) {
			System.out.println("Error: " + e.getMessage());
			return Response.status(Response.Status.NOT_FOUND).build();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return Response.serverError().build();
		}
		
		return Response.ok().build();
	}

}
