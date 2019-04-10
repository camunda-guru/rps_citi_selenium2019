package com.citi.banking.entities;

import java.time.LocalDate;

public class SoftSkillTraining extends Training{

	private boolean audioSystem;
	
	
	public SoftSkillTraining(int trainingCode, String venue, LocalDate date, String trainerName, boolean audioSystem) {
		super(trainingCode, venue, date, trainerName);
		this.audioSystem = audioSystem;
	}


	public void display()
	{
		super.display();
		System.out.println("Audio System"+ this.audioSystem);
	}
	
	
}
