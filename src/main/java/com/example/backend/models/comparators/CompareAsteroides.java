package com.example.backend.models.comparators;

import java.util.Comparator;

import com.example.backend.models.Asteroide;

public class CompareAsteroides implements Comparator<Asteroide> {
	
	public CompareAsteroides() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Asteroide o1, Asteroide o2) {
		int resultado=0;
		
		if(o1.getDiametro()>o2.getDiametro()) {
			resultado=-1;
		}else if(o1.getDiametro()<o2.getDiametro()) {
			resultado =1;
		}else if(o1.getDiametro()==o2.getDiametro()) {
			resultado=0;
		}
		
		if(resultado==0) {
			if(o1.getVelocidad()>o2.getVelocidad()) {
				resultado=-1;
			}else if(o1.getVelocidad()<o2.getVelocidad()) {
				resultado =1;
			}else if(o1.getVelocidad()==o2.getVelocidad()) {
				resultado=0;
			}
		}
		
		return resultado;
	}

}
