package com.hibernate.demo.entity;



import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//we use hibernate here to create sessions objects 
		// these session objects would create only once when app will run 
		
		
		//ceate session Factory 
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Student.class)
				                  .buildSessionFactory();
		
		//create sessoin
		
		       Session session =  factory.getCurrentSession();
		
				try {
					//use the session object to save java object
					System.out.println("create a student object ...");
					//create a student object
					Student tempstudent = new Student("Paul", "Wall", "paul@luvtocode.com");
					
					 //start a trasaction 
					session.beginTransaction();
					
					//save the student object
					//start the student object 
					System.out.println("saving the student ...");
					session.save(tempstudent);//method to save record 
					
					//commit trasaction 
					session.getTransaction().commit();
					System.out.println("Done");
				}
				
				finally {
					//
					factory.close();
				}
	}
	
	 

}
