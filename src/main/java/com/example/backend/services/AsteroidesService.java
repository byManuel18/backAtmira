package com.example.backend.services;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import javax.ws.rs.client.Client;
import org.springframework.stereotype.Service;
import com.example.backend.models.NearEarthObjectFeed;



@Service
public class AsteroidesService {
	
	private String url="https://api.nasa.gov/neo/rest/v1/feed?";
	private String start_date="start_date=";
	private String end_date="&end_date=";
	private String apikey="&api_key=zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb";
	public void getAlgo() {
		LocalDate date=LocalDate.now();
		String datenow=date.toString();
		date.plusDays(7);
		String datenext=date.toString();
		System.out.println(datenow);
		System.out.println(datenext);
		/*Client cliente=ClientBuilder.newClient();
		
		NearEarthObjectFeed lista=  cliente.target(url)
		.request(MediaType.APPLICATION_JSON).get(NearEarthObjectFeed.class);
		cliente.close();
		System.out.println(lista.getElement_count());*/
	}
}
