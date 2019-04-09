package com.citi.banking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import com.citi.banking.entities.Customer;

class CustomerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//created customer object
		
		Scanner scanner = new Scanner(System.in);		
		
		Customer customer =new Customer();
		//set the values
		System.out.println("Enter First Name");		
		customer.setFirstName(scanner.nextLine());
		System.out.println("Enter Last Name");
		customer.setLastName(scanner.nextLine());
		System.out.println("Enter Salary");
		customer.setSalary(scanner.nextLong());
		scanner.nextLine();
		System.out.println("Enter Date of birth(dd-MMM-yyyy)");
		String dob = scanner.nextLine();
		//convert string to date
		SimpleDateFormat ft = new SimpleDateFormat("dd-MMM-yyyy");
		Date dateobj=null;
		try {
			dateobj=ft.parse(dob);
			customer.setDob(LocalDate.of(dateobj.getYear(),dateobj.getMonth(),dateobj.getDay()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Welcome to Selenium Training");
		
		//read the values
		
		System.out.println("First Name=\t"+customer.getFirstName());
		System.out.println("Last Name=\t"+customer.getLastName());
		System.out.println("Salary=\t"+customer.getSalary());
		System.out.println("DOB=\t"+customer.getDob().toString());
		

	}

	
	
}
