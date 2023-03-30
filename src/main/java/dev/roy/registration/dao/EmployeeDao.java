package dev.roy.registration.dao;

import dev.roy.registration.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDao {

    private final SessionFactory sessionFactory;

    public EmployeeDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    /** Create New Employee
      * param - Employee Object
     **/
    public void saveEmployee(Employee employee) {
        //Set new employee to null
        boolean newEmployee = false;
        //Open Session
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();

    }
}
