package org.issa.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity 
public class Produit implements Serializable {

      @Id
      @GeneratedValue
	  private Long id ;
	   // @Column(name = "ean_code", nullable = true, length = 13)
	//private String codeEan13;
	//private String description;
	
	private String product_name;
	private String code ;
	private Boolean status;
	private String  status_verbose;
	
	
	
	
	


	public Produit(String product_name, String code) {
		super();
		this.product_name = product_name;
		this.code = code;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStatus_verbose() {
		return status_verbose;
	}


	public void setStatus_verbose(String status_verbose) {
		this.status_verbose = status_verbose;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}

//
//	@ManyToOne
//	@JoinColumn(name="ID_CAT")
//	private Categories categorie;
//	 
	 
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}


//	public Categories getCategorie() {
//		return categorie;
//	}
//
//
//	public void setCategorie(Categories categorie) {
//		this.categorie = categorie;
//	}


	




	


	


	
	
	

}
