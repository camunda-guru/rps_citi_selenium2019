package com.citi.banking.entities;

import java.time.LocalDate;

public class TechnicalTraining extends Training{
	
	private boolean hardware;
	private boolean software;
	
	public TechnicalTraining(int trainingCode, String venue, LocalDate date, String trainerName, boolean hardware,
			boolean software) {
		super(trainingCode, venue, date, trainerName);
		this.hardware = hardware;
		this.software = software;
	}

	public void display()
	{
		super.display();
		System.out.println("Hardware"+ this.hardware);
		System.out.println("Software"+ this.software);
	}
	

}
