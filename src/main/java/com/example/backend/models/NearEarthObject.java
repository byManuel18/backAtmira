package com.example.backend.models;

import java.util.List;



public class NearEarthObject {
		
		private Links links;
	
	    private String id;
	   
	    private String neo_reference_id;
	    
	    private String name;
	    
	    private String nasa_jpl_url;
	    
	    private double absolute_magnitude_h;
	    
	    private EstimatedDiameter estimated_diameter;
	    
	    private boolean is_potentially_hazardous_asteroid;
	 
	    private List<CloseApproach> close_approach_data;
	    
	    private boolean is_sentry_object;
		
	    public Links getLinks() {
			return links;
		}
		public String getId() {
			return id;
		}
		public String getNeo_reference_id() {
			return neo_reference_id;
		}
		public String getName() {
			return name;
		}
		public String getNasa_jpl_url() {
			return nasa_jpl_url;
		}
		public double getAbsolute_magnitude_h() {
			return absolute_magnitude_h;
		}
		public EstimatedDiameter getEstimated_diameter() {
			return estimated_diameter;
		}
		public boolean isIs_potentially_hazardous_asteroid() {
			return is_potentially_hazardous_asteroid;
		}
		public List<CloseApproach> getClose_approach_data() {
			return close_approach_data;
		}
		public boolean isIs_sentry_object() {
			return is_sentry_object;
		}

	    
}
