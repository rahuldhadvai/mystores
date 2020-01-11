package com.project.MyStores_b.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class store  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer store_id;
	
	@Column
	String store_name;
	
	@Column
	String store_address;
	
	@Column
	String store_category;
	
	
	@Column
	long latitude;
	
	@Column
	long longitude;
	
	@Column
	String store_owner;

	public store(Integer store_id, String store_name, String store_address, String store_category, long latitude,
			long longitude, String store_owner) {
		super();
		this.store_id = store_id;
		this.store_name = store_name;
		this.store_address = store_address;
		this.store_category = store_category;
		this.latitude = latitude;
		this.longitude = longitude;
		this.store_owner = store_owner;
	}

	public store() {
		super();
	}

	public Integer getStore_id() {
		return store_id;
	}

	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_address() {
		return store_address;
	}

	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}

	public String getStore_category() {
		return store_category;
	}

	public void setStore_category(String store_category) {
		this.store_category = store_category;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public String getStore_owner() {
		return store_owner;
	}

	public void setStore_owner(String store_owner) {
		this.store_owner = store_owner;
	}

	@Override
	public String toString() {
		return "store [store_id=" + store_id + ", store_name=" + store_name + ", store_address=" + store_address
				+ ", store_category=" + store_category + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", store_owner=" + store_owner + "]";
	}
	
	
	
}
