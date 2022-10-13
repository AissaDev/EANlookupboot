package org.issa.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
public class Categories implements Serializable {
	@Id @GeneratedValue
	private Long id ;
	private String nomCategorie;
	
      //@OneToMany(mappedBy="categorie",fetch=FetchType.LAZY)
	//private Collection<Produit> produits;
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Categories(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomCategorie() {
		return nomCategorie;
	}


	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

//	@JsonIgnore
//	@XmlTransient
//	public Collection<Produit> getProduits() {
//		return produits;
//	}
//
//
//	public void setProduits(Collection<Produit> produits) {
//		this.produits = produits;
//	}
	
	

}
