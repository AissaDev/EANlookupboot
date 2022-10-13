package org.issa.dao;

import java.util.List;

import org.issa.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

//	@Query("select p from Produit p where p.description like :x")
//	public Page<Produit>lookupByDescription(@Param("x") String mc,Pageable pageable);
//	
	/*
	@Query("select p from Produit p where p.description like:x")
	public List<Produit> EANlookupByKeysWords (@Param("x")String mc);*/
	//comme dans client rest  rajouter recherche par mc qui donne une liste de produit et enleve la quantite remplace la par product name

//	@Query("select p from Produit p where p.product_Name like :x")
//	public Page<Produit>lookupByName(@Param("x") String mc,Pageable pageable);
	
//	public List<Produit> findByProduct_name(String productname);
//	public Page<Produit> findByProduct_Name(String productname,Pageable p );
}
