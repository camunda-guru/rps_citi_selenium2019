package com.citi.banking;


import java.util.Scanner;

import org.bson.Document;

import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public class CustomerApp {

	public static void write(MongoCollection collection)
	{
		//Document
					
				Document doc; 
				Scanner scanner=new Scanner(System.in);				
				for(int i=0;i<5;i++)
				{
					System.out.println("Enter First Name");
					
						doc=new Document("firstName",scanner.nextLine());
						System.out.println("Enter Last Name");
						doc.append("lastName", scanner.nextLine());
						System.out.println("Enter Salary");
						doc.append("salary", scanner.nextInt());
						scanner.nextLine();
						System.out.println("Enter DOB");
						doc.append("dob", scanner.nextLine());
						collection.insertOne(doc);
				}
		
	}
	
	public static void read(MongoCollection collection)
	{
		//reading 
		
	 MongoCursor cursor =collection.find().iterator();
         while(cursor.hasNext())
         {
        	 System.out.println(cursor.next());
         }
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//connection test
		MongoClient client=new MongoClient("localhost",27017);
		System.out.println("Connection created");
		//create database
		MongoDatabase db = client.getDatabase("citidb");
		//create collection
		MongoCollection collection =db.getCollection("customers");		
		//write(collection);		
		read(collection);
		
	}

}
