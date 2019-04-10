package com.citi.banking.entities;

import java.time.LocalDate;
//super class
public class Training {

	protected int trainingCode;
	protected String venue;
	protected LocalDate date;
	protected String trainerName;
	
	
	public Training(int trainingCode, String venue, LocalDate date, String trainerName) {
		super();
		this.trainingCode = trainingCode;
		this.venue = venue;
		this.date = date;
		this.trainerName = trainerName;
	}


	public void display()
	{
		System.out.println("Training Code"+ this.trainingCode);
		System.out.println("Venue"+ this.venue);
		System.out.println("Traiing Date"+ this.date.toString());
		System.out.println("Training Name"+ this.trainerName);
		
	}


	
	
	
}
