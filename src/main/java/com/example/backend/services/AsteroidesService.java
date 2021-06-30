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
	
	private final String URL="https://api.nasa.gov/neo/rest/v1/feed?";
	private final String START_DATE="start_date=";
	private final String END_DATE="&end_date=";
	private final String APIKEY="&api_key=zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb";
	private final int PLUSDAYS=7;
	
	/**
	 * Método que devuelve una lista de 3 asteroides ordenados por diámetro y velocidad según el planeta introducido
	 * @param planeta Planeta del que queremos ver los Asteroides
	 * @return Una lista ordenada con los 3 asteroides peligrosos con más diámetro
	 */
	public Set<Asteroide> getAsteroides(String planeta) {
		Set<Asteroide> listaasteroides=new TreeSet<Asteroide>(new CompareAsteroides());
		Set<Asteroide> datosamostrar=new TreeSet<Asteroide>(new CompareAsteroides());
		
		NearEarthObjectFeed apiJson= getObjectFromApi();
		if(apiJson!=null) {
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
		}
		
		
		for(Asteroide as:listaasteroides) {
			if(datosamostrar.size()<3) {
				datosamostrar.add(as);
			}
		}
		
		return datosamostrar;
		
	}
	
	/**
	 * Método que realiza una petición a la Api de la nasa con la fecha de hoy y 7 días más
	 * transformando el JSON que trae en un Objeto NearEarthObjectFeed
	 * @return objeto NearEarthObjectFeed transformado del JSON
	 */
	private NearEarthObjectFeed getObjectFromApi() {
		LocalDate datenow=LocalDate.now();
		LocalDate dateend=datenow.plusDays(this.PLUSDAYS);
		String endpoint=this.URL+this.START_DATE+datenow+this.END_DATE+dateend+this.APIKEY;
		NearEarthObjectFeed objApi=null;
		
		try {
			Client cliente=ClientBuilder.newClient();
			objApi=cliente.target(endpoint)
			.request(MediaType.APPLICATION_JSON).get(NearEarthObjectFeed.class);
			cliente.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return objApi;
	}
}
