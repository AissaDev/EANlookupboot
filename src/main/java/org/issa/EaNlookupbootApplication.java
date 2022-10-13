package org.issa;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.issa.dao.ProduitRepository;
import org.issa.entities.Produit;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class EaNlookupbootApplication implements CommandLineRunner {

	@Autowired 
	private ProduitRepository produitRepository;
	static List<Produit> prods= new ArrayList<Produit>();
	
	public static final String REST_SERVICE_URI = "http://fr.openfoodfacts.org/api/v0";
	  @SuppressWarnings("unchecked")
	  private static List<Produit> listAllUsers() throws IOException{
		  
		  BufferedReader lecteurAvecBuffer = null;
          String ligne;
		  System.out.println("Testing listAllUsers API-----------");
		
		  
	      try {
	    	     
	    	  
	          long startTime = System.currentTimeMillis();
	          
	                    
	          lecteurAvecBuffer = new BufferedReader(new FileReader("text.txt"));
	          while ((ligne = lecteurAvecBuffer.readLine()) != null){
	    	      RestTemplate restTemplate = new RestTemplate();
	    	     String userMap =  restTemplate.getForObject(REST_SERVICE_URI+"/Product/"+ligne,String.class);
	    	     
	    	     System.out.println(userMap);
	    	     
	    	     ObjectMapper mapper = new ObjectMapper();
	    	     Produit obj = mapper.readValue(userMap, Produit.class);
	    	 
	    	   
	    	    prods.add(obj);
	    	     
	    	    
	    	    for (Produit produit : prods) {
					
	    	    	System.out.println(produit.getCode());
	    	    }
	          System.out.println("Temps de lecture + écriture avec BufferedInputStream : " + (System.currentTimeMillis() - startTime));
	                    
	         
	          
	         
	          
	          }
	                    
	        } catch (FileNotFoundException e) {
	          e.printStackTrace();
	        } 
	    
	      lecteurAvecBuffer.close();

		return prods;
	      
	      
	      
	      
	  }
	
	public static void main(String[] args) {
		

		SpringApplication.run(EaNlookupbootApplication.class, args);
		
		
		

	}

	@Override
	public void run(String... arg0) throws Exception {
		
//	//System.out.println(listAllUsers());	
//		//ProduitRepository produitRepository=ctx.getBean(ProduitRepository.class);
		produitRepository.save(new Produit("1236549873216","06djp matines fraicheur coque "));
		produitRepository.save(new Produit("1236549883216","06djp matines gros "));
		produitRepository.save(new Produit("1236949873217"," 1flacon correcteur mousse tipp-ex 20ml"));
		produitRepository.save(new Produit("9121778300000","Cola zéro - coca - 1"));
		
		List<Produit> prods=produitRepository.findAll();
		prods.forEach(p->System.out.println(p.getCode()+" "+p.getProduct_name()));

		
	}
	
}
