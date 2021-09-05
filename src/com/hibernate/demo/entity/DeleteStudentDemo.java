package com.hibernate.demo.entity;



import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {								
			int studentId = 1;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			// delete the student
			// System.out.println("Deleting student: " + myStudent);
			// session.delete(myStudent);

			// delete student id=2
			System.out.println("Deleting student id=2");

			session.createQuery("delete from Student where id=2").executeUpdate();//method to delete the record 

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		finally {
				factory.close();
		}
	}
		
		}
	
	 


