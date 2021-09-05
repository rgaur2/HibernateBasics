package com.hibernate.demo.entity;



import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class createStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //we use hibernate here to create sessions objects 
		// these session objects would create only once when app will run 
		
		
		//ceeate session Factory Read the Congif file .Heavy weight object created one time
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Student.class)
				                  .buildSessionFactory();
		
		//create session 
		// Wraps a jdbc connection Main object used to save /retrieve objects 
		//short lived object retrieved from Session Factory
		
		Session session =  factory.getCurrentSession();
		
				try {
					//use the session object to save java object
					System.out.println("create a student object ...");
					//create a student object
					Student tempstudent = new Student("Daffy", "Duck", "daffy@luvtocode.com");
					
					 //start a trasaction 
					session.beginTransaction();
					
					//save the student object
					//start the student object 
					System.out.println("saving the student ...");
					session.save(tempstudent);
					
					//commit trasaction 
					session.getTransaction().commit();
					
					//My new code to retrieve data from database
					
					
					//find out the student';s id: primary key
					System.out.println("Saved student.Generated id :" + tempstudent.getId() );
					
					//now get a new session and start trasaction 
					session = factory.getCurrentSession();
					session.beginTransaction();
					//retrived student based on the id :primary key
					System.out.println("\nGetting students with id: " + tempstudent.getId());
					
					Student mystudent = session.get(Student.class, tempstudent.getId());
					//used to retrieve the all record of specific id
					//used to retrieve the id from database 
					//if id does not exist in database it return null
					
					System.out.println("Get Complete" + mystudent);
					
					//commit the trasaction
					
					session.getTransaction().commit();
					System.out.println("Done");
				}
				
				finally {
					//
					factory.close();
				}
	}
	
	 

}
