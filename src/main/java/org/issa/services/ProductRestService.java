package org.issa.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.issa.dao.ProduitRepository;
import org.issa.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ProductRestService {

	
	  @Autowired
	    private ProduitRepository produitRepository;
	  
	    @RequestMapping(value="/test",method=RequestMethod.GET)
	    public String test(){
	    	return "test ";
	    }
	    
	    @RequestMapping(value="/produits",method=RequestMethod.GET)
	    public Page<Produit> listProduit(int page,int size){
			return produitRepository.findAll(new PageRequest(page, size) );
	    	
	    }
	    
//	    @RequestMapping(value="/lookupByDescription",method=RequestMethod.GET)
//	    public Page<Produit> chercher(
//	    		String mc,
//	    		@RequestParam(name="page",defaultValue="0") int page,
//	    		@RequestParam(name="size",defaultValue="5") int size){
//			return produitRepository.lookupByDescription("%"+mc+"%", new PageRequest(page, size));
//	    	
//	    }
//	    
	    @RequestMapping(value="/produits/{id}",method=RequestMethod.GET)
	    public Produit getProduit(@PathVariable ("id")Long id ){
			return produitRepository.findOne(id);
	    	
	    }
//	    
	    @RequestMapping(value="/produits",method=RequestMethod.POST)
	    public Produit save(@RequestBody Produit p){
	    	return produitRepository.save(p);
	    }
	    
	    @RequestMapping(value="/produits/{id}",method=RequestMethod.PUT)
	    public Produit update(@RequestBody Produit p,@PathVariable Long id){
	    	p.setId(id);
	    	return produitRepository.saveAndFlush(p);
	    }
    
	    @RequestMapping(value="/produits/{id}",method=RequestMethod.DELETE)
	    public void delete(@RequestBody Produit p,@PathVariable Long id){
	    	p.setId(id);
	    	 produitRepository.delete(id);
	    }
//	    
//	    
//	    
//	    @RequestMapping(value="/lookupByName",method=RequestMethod.GET)
//	    public Page<Produit> lookupByName(
//	    		String mc,
//	    		@RequestParam(name="page",defaultValue="0") int page,
//	    		@RequestParam(name="size",defaultValue="5") int size){
//			return produitRepository.lookupByName("%"+mc+"%", new PageRequest(page, size));
//	    	
//	    }
//	    
	   
	    public static final String REST_SERVICE_URI = "http://fr.openfoodfacts.org/api/v0";
		 
		  
	    
	      @RequestMapping(value="/lookupByFileData",method=RequestMethod.GET)
		  public List<Produit> lookupcode(String file) throws IOException{
	    	  
	    	  
	    	  List<Produit> prods= new ArrayList<Produit>();
	    	  BufferedReader lecteurAvecBuffer = null;
	          String ligne;
			  System.out.println("Testing listAllUsers API-----------");
			
			  
		      try {
		    	     
		    	  
		          long startTime = System.currentTimeMillis();
		          
		                    
		          lecteurAvecBuffer = new BufferedReader(new FileReader(file));
		          while ((ligne = lecteurAvecBuffer.readLine()) != null){
		    	      RestTemplate restTemplate = new RestTemplate();
		    	    Produit userMap =  restTemplate.getForObject(REST_SERVICE_URI+"/Product/"+ligne,Produit.class);
		    	     
		    	     System.out.println(userMap);
		    	     
		    	     //ObjectMapper mapper = new ObjectMapper();
		    	     //Produit obj = mapper.readValues(userMap, Produit.class);
		    	    prods.add(userMap); 
		    	    for (Produit produit : prods) {
						
		    	    	System.out.println(produit.getCode());
		    	    }
		          System.out.println("Temps de lecture (Time OF READING ) : " + (System.currentTimeMillis() - startTime));  
		          
		          }
		                    
		        } catch (FileNotFoundException e) {
		          e.printStackTrace();
		        } 
		    
		      lecteurAvecBuffer.close();

			return prods;
		      
		      
		      
		      
		  }
	    
	      
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	   /* @RequestMapping(value="/productByName",method=RequestMethod.GET)
	    public Page<Produit> productByName(
	    		String c,
	    		@RequestParam(name="page",defaultValue="0") int page,
	    		@RequestParam(name="size",defaultValue="5") int size
	    		){
	    	
	    return produitRepository.findByProductName(c, new PageRequest(page, size));
	    }*/
	    
	   /* @RequestMapping(value="/EANlookupByKeysWords",method=RequestMethod.GET)
		public List<Produit> Lookup(String mc) {                          
	    	
			return produitRepository.EANlookupByKeysWords("%"+mc+"%");
		}*/
	    
	   /* @RequestMapping(value="/EANlookupByKeysWords/{mc}",method=RequestMethod.GET)
		public List<Produit> Lookup(@PathVariable String mc) {
	    	
			return produitRepository.EANlookupByKeysWords("%"+mc+"%");
		}*/
	    
	    
}
