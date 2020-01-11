package com.project.MyStores_b.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.MyStores_b.beans.store;

public interface StoreRepository extends CrudRepository<store, Integer> {

	@Query("select s from store s where s.store_name LIKE %?1%")
	public Iterable<store> searchbyname(String search_text);
	
	
	//@Query("SELECT id, ( 3959 * acos( cos( radians(37) ) * cos( radians( lat ) ) * cos( radians( lng ) - radians(-122) ) + sin( radians(37) ) * sin( radians( lat ) ) ) ) AS distance FROM markers HAVING distance < 25 ORDER BY distance LIMIT 0 , 20")
	//public Iterable<store> searchbylocation(int lat,int lng);
}