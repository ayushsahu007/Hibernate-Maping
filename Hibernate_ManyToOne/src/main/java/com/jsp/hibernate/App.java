package com.jsp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
        Company company = new Company();
        company.setCompanyId(1);
        company.setCompanyName("Google");
        
    	Employee employee1 = new Employee();
    	employee1.setEmployeeId(101);
    	 employee1.setEmployeeName("A");
    	 employee1.setSalary(1234);
    	 
    	 Employee employee2 = new Employee();
     	employee2.setEmployeeId(102);
     	 employee2.setEmployeeName("B");
     	 employee2.setSalary(1234);
       
       //Adding Company into employee
  	 employee1.setCompany(company);
  	 employee2.setCompany(company);
  	 
     Configuration cfg = new Configuration().configure()
  		   .addAnnotatedClass(Employee.class)
  		   .addAnnotatedClass(Company.class);
  	 
  	 SessionFactory sf = cfg.buildSessionFactory();
  	 Session session = sf.openSession();
  	 Transaction tran = session.beginTransaction();
  	 
  	 session.save(employee1);
  	 session.save(employee2);
  	 session.save(company);
  			 
 
        tran.commit();
        session.close();
        sf.close();
       
  			  
    }
}
