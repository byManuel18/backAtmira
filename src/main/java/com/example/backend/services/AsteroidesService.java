package com.example.backend.services;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import javax.ws.rs.client.Client;
import org.springframework.stereotype.Service;
import com.example.backend.models.NearEarthObjectFeed;

@Service
public class AsteroidesService {
	
	private static final String URL="https://api.nasa.gov/neo/rest/v1/feed?";
	private static final String START_DATE="start_date=";
	private static final String END_DATE="&end_date=";
	private static final String APIKEY="&api_key=zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb";
	private static final int PLUSDAYS=7;
	
	public void getAlgo() {
		LocalDate date=LocalDate.now();
		LocalDate dateend=date.plusDays(this.PLUSDAYS);
		String datenow=date.toString();
		String datenext=dateend.toString();
		String endpoint=this.URL+this.START_DATE+datenow+this.END_DATE+datenext+this.APIKEY;
		/*Client cliente=ClientBuilder.newClient();
		
		NearEarthObjectFeed lista=  cliente.target(endpoint)
		.request(MediaType.APPLICATION_JSON).get(NearEarthObjectFeed.class);
		cliente.close();
		System.out.println(lista.getElement_count());*/
	}
}
