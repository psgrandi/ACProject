package br.com.ac.avenue.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.annotations.Expose;

/**
 * Entity of Products
 * @author psilveira
 *
 */
@Entity
@Table
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@Expose
	@Column(name = "NAME")
	private String name;
	
	@Expose
	@Column(name = "DESCRIPTION")
	private String description;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade={CascadeType.REMOVE})
	private Set<Image> images;
	
	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, cascade={CascadeType.REMOVE})
    private Set<Product> children;
	
	@JsonIgnore
    @ManyToOne(optional = true)
    @JoinColumn(name = "PARENT_PRODUCT_ID")
    private Product parent;   

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}	

	public Product getParent() {
		return parent;
	}

	public void setParent(Product parent) {
		this.parent = parent;
	}

	public Set<Product> getChildren() {
		return children;
	}

	public void setChildren(Set<Product> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + "]";
	}
}
