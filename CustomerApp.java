package com.citi.banking;


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
				Document doc =new Document("firstName","Parameswari");
				doc.append("lastName", "bala");
				doc.append("salary", 356796);
				doc.append("dob", "1970-12-2");
				collection.insertOne(doc);
		
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
