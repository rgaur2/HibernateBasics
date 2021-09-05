package com.hibernate.demo.entity;



import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateStudentDemo {

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
					
					int studentId=1;
					 
				
					
					//My new code
					//Got a new session and start trasaction 
					session = factory.getCurrentSession();
					session.beginTransaction();
					//retrived student based on the id :primary key
					
					System.out.println("\nGetting students with id: " + studentId);
					
					Student mystudent = session.get(Student.class, studentId);
					//used to retrieve the all record of specific id
					//used to retrieve the id from database 
					//if id does not exist in database it return null
					
					System.out.println("updating student");
					mystudent.setFirstName("Scooby");
					
					//commit the trasaction
					
					session.getTransaction().commit();
					
					
					
					//My new code 
					session = factory.getCurrentSession();
					session.beginTransaction();
					
					
					//update email for all students
					
					System.out.println("update email for all students ");
					session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();//method to update  reusult
					
					
					
					
					//commit the trasaction 
					session.getTransaction().commit();
					
					System.out.println("done");
					
					
					
					
					
					
					System.out.println("Done");
				
				}
				
				finally {
					//
					factory.close();
				}
	}
	
	 

}
