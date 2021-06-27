package com.example.backend.models;

import java.util.List;
import java.util.Map;



public class NearEarthObjectFeed {
	private Links links;
    
    private int element_count;
   
    private Map<String, List<NearEarthObject>> near_earth_objects;
    
	public Links getLinks() {
		return links;
	}
	public int getElement_count() {
		return element_count;
	}
	public Map<String, List<NearEarthObject>> getNear_earth_objects() {
		return near_earth_objects;
	}

 
}
