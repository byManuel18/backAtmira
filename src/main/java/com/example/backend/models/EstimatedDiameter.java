package com.example.backend.models;

public class EstimatedDiameter {
	
	 private EstimatedDiameterUnit kilometers;
     private EstimatedDiameterUnit meters;
     private EstimatedDiameterUnit miles;
     private EstimatedDiameterUnit feet;

     public EstimatedDiameterUnit getKilometers() {
         return kilometers;
     }

     public EstimatedDiameterUnit getMeters() {
         return meters;
     }

     public EstimatedDiameterUnit getMiles() {
         return miles;
     }

     public EstimatedDiameterUnit getFeet() {
         return feet;
     }
}
