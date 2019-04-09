package com.citi.banking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import com.citi.banking.entities.Customer;

class CustomerApp {
	
   public static Customer assignvalues(Customer customer)
   {
	   Scanner scanner = new Scanner(System.in);
	   System.out.println("Enter First Name");		
		customer.setFirstName(scanner.nextLine());
		System.out.println("Enter Last Name");
		customer.setLastName(scanner.nextLine());
		System.out.println("Enter Salary");
		customer.setSalary(scanner.nextLong());
		scanner.nextLine();
		System.out.println("Enter year");
		int year=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter month");
		int month=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter day");
		int day=scanner.nextInt();
		scanner.nextLine();		
		customer.setDob(LocalDate.of(year, month, day));
		return customer;
   }
	
   public static void readvalues(Customer customer)
   {
	   System.out.println("First Name=\t"+customer.getFirstName());
		System.out.println("Last Name=\t"+customer.getLastName());
		System.out.println("Salary=\t"+customer.getSalary());
		System.out.println("DOB=\t"+customer.getDob().toString());
	   
   }
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//created customer object	
		//Array
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter Customer Count");
		int count=scanner.nextInt();
		scanner.nextLine();
		Customer[] customerArray =new Customer[count];					
		//set the values
		for(int i=0;i<count;i++)
		{
		    customerArray[i]=new Customer();
		    customerArray[i]=assignvalues(customerArray[i]); 	
		}	
		//read the values
		//enhanced for loop
		
		for(Customer obj : customerArray)
		 readvalues(obj);
		
		

	}

	
	
}
