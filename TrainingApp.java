package com.citi.banking;

import java.time.LocalDate;

import com.citi.banking.entities.SoftSkillTraining;
import com.citi.banking.entities.TechnicalTraining;

public class TrainingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//object
		SoftSkillTraining softSkillTraining=new SoftSkillTraining(101,"Spindle",
				LocalDate.of(2019,4,20),"Sakshi",true);
		softSkillTraining.display();
		
		TechnicalTraining technicalTraining=new TechnicalTraining(201,"Hibiscus",
				LocalDate.of(2019,4,9),"Parameswari",true,true);
		technicalTraining.display();
		
		
	}

}
