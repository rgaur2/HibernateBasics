package com.hibernate.demo.entity;



import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //we use hibernate here to create sessions objects 
		// these session objects would create only once when app will run 
		
		
		//ceate session Factory 
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Student.class)
				                  .buildSessionFactory();
		
		//create session
		
		Session session =  factory.getCurrentSession();
		
		//Follwing code we filter out student who;s ;last name is 'Doe'
		
				try {
					
					
					//start a trasaction 
					session.beginTransaction();
					//query students
					List<Student> theStudents = session.createQuery("from Student").list();
					 
					//display the student
					displayStudents(theStudents); 
					
					//query student :lastname ='Doe'
					
					theStudents = session.createQuery("from Student s where s.lastName ='Doe'").getResultList();//method to read result 
					//display the students 
					System.out.println("\n\nStudents who have last name of Doe");
					displayStudents(theStudents); 
					
					
					
					
					//query student:lastname ='Doe' or firstname ='Daffy'
					theStudents =
							session.createQuery("from Student s where"
									+ " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
					
					System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
					displayStudents(theStudents);
				 
					// query students where email LIKE %luv2code.com
					theStudents = session.createQuery("from Student s where"+ " s.email LIKE '%gmail.com'").getResultList();

					
					
					System.out.println("\n\n students whose emails ends with luvtocode.com");
					displayStudents(theStudents);
					
					//commit the trasaction 
				    session.getTransaction().commit();
					System.out.println("Done!");
				}
				
				finally {
					//
					factory.close();
				}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents)
		{
			System.out.println(tempStudent);
		}
	}
	
	 

}
