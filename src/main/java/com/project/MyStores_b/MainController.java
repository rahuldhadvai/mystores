package com.project.MyStores_b;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.MyStores_b.Repositories.StoreRepository;
import com.project.MyStores_b.beans.store;

import antlr.collections.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MainController {

	@Autowired
	StoreRepository store_repository;
	
	
	// To Add a New Store
	  @PostMapping("/add")
	  public store  addNewStore(@RequestBody store store_obj) {
		
	   store_repository.save(store_obj);
	   return  store_obj; 
	  }

	  // To get the List of All stores
	  @GetMapping(path="/all")
	  public  Iterable<store> getAllStores() {
	    // This returns a JSON or XML with the users
	    return store_repository.findAll();
	  }
	  
	  // to search stores by name
	  @GetMapping(path="/findbyname/{search_text}")
	  public  Iterable<store> findStoresByName(@PathVariable("search_text") String search_text) {
	    // This returns a JSON or XML with the users
	    return store_repository.searchbyname(search_text);
	  }
	  
	  // to search stores by location within 100kms radius
	  @GetMapping(path="/findbyloc/{lat}/{lng}")
	  public  ArrayList<store> findStoresByLocation(@PathVariable("lat") Double lati,@PathVariable("lng") Double longi) {
	    Iterable<store> all_stores = store_repository.findAll();
		  
		  ArrayList<store> final_list = new ArrayList<store>();
		  
		  for(store e : all_stores)
		  {
			  double dist = distance(lati, longi, e.getLatitude(), e.getLongitude(), "K");
			  if(dist <100 )
			  {
				  final_list.add(e);
			  }
		  }
		  
		  
		  return final_list;
	   
	  }
	  
	  // to find the distance between two coordinates
	  private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
			if ((lat1 == lat2) && (lon1 == lon2)) {
				return 0;
			}
			else {
				double theta = lon1 - lon2;
				double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
				dist = Math.acos(dist);
				dist = Math.toDegrees(dist);
				dist = dist * 60 * 1.1515;
				if (unit.equals("K")) {
					dist = dist * 1.609344;
				} else if (unit.equals("N")) {
					dist = dist * 0.8684;
				}
				return (dist);
			}
		}
}
