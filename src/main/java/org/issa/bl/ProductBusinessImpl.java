package org.issa.bl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.issa.entities.Produit;
import org.springframework.web.client.RestTemplate;

public class ProductBusinessImpl implements IProduct {
//	public static final String REST_SERVICE_URI = "http://fr.openfoodfacts.org/api/v0";
//	 BufferedInputStream bis;
//	 BufferedOutputStream bosfound; 
//	 BufferedOutputStream bosnotfound; 
//	
////	@SuppressWarnings("unchecked")
//	  public void listAllProductlookup() {
//		 
//	      System.out.println("Testing listAllUsers API-----------");
//	      try {
//	    	     
//	          bis = new BufferedInputStream(new FileInputStream(new File("test.txt")));
//	          bosfound = new BufferedOutputStream(new FileOutputStream(new File("testfound.txt")));
//	          bosnotfound = new BufferedOutputStream(new FileOutputStream(new File("testnotfound.txt")));
//	          
//	          byte[] buf = new byte[8];
//	     
//	          //On récupère le temps du système
//	          long startTime = System.currentTimeMillis();
//	                    
//	     
//	          while(bis.read(buf) != -1){
//	        	  //rasoir 2 lames x10 jetables auchan
//	    	      RestTemplate restTemplate = new RestTemplate();
//	    	     Produit usersMap =  restTemplate.getForObject(REST_SERVICE_URI+"/Product/"+buf.toString(),Produit.class);
//	    	       
//	    	      if(usersMap.getStatus()!=false){
//	    	    	  bosfound.write(buf);
//	    	              //System.out.println(usersMap.getCode());
//	    	      }else{
//	    	    	  bosnotfound.write(buf);
//	    	    	  
//	    	         // System.out.println("product not found----------");
//	    	         // System.out.println(usersMap.getCode());
//	    	      }
//	            
//	          }
//	          //On réaffiche
//	          System.out.println("Temps de lecture + écriture avec BufferedInputStream : " + (System.currentTimeMillis() - startTime));
//	                    
//	          //On ferme nos flux de données
//	        
//	          bis.close();
//	          bosfound.close();
//	          bosnotfound.close();
//	         
//	                    
//	        } catch (FileNotFoundException e) {
//	          e.printStackTrace();
//	        } catch (IOException e) {
//	          e.printStackTrace();
//	        } 
//	      
//	      
//	      
//		
//	  }

}
