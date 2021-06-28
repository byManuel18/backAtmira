package com.example.backend.services;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.ws.rs.client.Client;
import org.springframework.stereotype.Service;
import com.example.backend.models.Asteroide;
import com.example.backend.models.CloseApproach;
import com.example.backend.models.NearEarthObject;
import com.example.backend.models.NearEarthObjectFeed;
import com.example.backend.models.comparators.CompareAsteroides;

@Service
public class AsteroidesService {
	
	private static final String URL="https://api.nasa.gov/neo/rest/v1/feed?";
	private static final String START_DATE="start_date=";
	private static final String END_DATE="&end_date=";
	private static final String APIKEY="&api_key=zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb";
	private static final int PLUSDAYS=7;
	
	public Set<Asteroide> getAsteroides(String planeta) {
		LocalDate date=LocalDate.now();
		LocalDate dateend=date.plusDays(this.PLUSDAYS);
		String datenow=date.toString();
		String datenext=dateend.toString();
		String endpoint=this.URL+this.START_DATE+datenow+this.END_DATE+datenext+this.APIKEY;
		Set<Asteroide> listaasteroides=new TreeSet<Asteroide>(new CompareAsteroides());
		Set<Asteroide> datosamostrar=new TreeSet<Asteroide>(new CompareAsteroides());
		Client cliente=ClientBuilder.newClient();
	
		NearEarthObjectFeed apiJson=  cliente.target(endpoint)
		.request(MediaType.APPLICATION_JSON).get(NearEarthObjectFeed.class);
		cliente.close();
		for(Map.Entry<String, List<NearEarthObject>> entry:apiJson.getNear_earth_objects().entrySet()) {
			for(NearEarthObject neo:entry.getValue()) {
				if(neo.isIs_potentially_hazardous_asteroid()) {
					
					Asteroide nuevo=new Asteroide();
					nuevo.setNombre(neo.getName());
					double diametromedio=((Double.parseDouble(neo.getEstimated_diameter().getKilometers().getEstimated_diameter_max())+Double.parseDouble(neo.getEstimated_diameter().getKilometers().getEstimated_diameter_min()))/2);
					nuevo.setDiametro(diametromedio);
					
					for(CloseApproach ca:neo.getClose_approach_data()) {
						nuevo.setPlaneta(ca.getOrbiting_body());
						nuevo.setFecha(ca.getClose_approach_date());
						nuevo.setVelocidad(Double.parseDouble(ca.getRelative_velocity().getKilometers_per_hour()));
						if(planeta.toUpperCase().equals(ca.getOrbiting_body().toUpperCase())) {
							listaasteroides.add(nuevo);
						}
						
					}
				}
				
			}
		}
		for(Asteroide as:listaasteroides) {
			if(datosamostrar.size()<3) {
				datosamostrar.add(as);
			}
		}
		
		return datosamostrar;
		
	}
}
