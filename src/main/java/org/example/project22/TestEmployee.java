package org.example.project22;

import org.example.project22.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestEmployee {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Vladimir", "Minin",
                   "IT", 1200);
            session.beginTransaction();
            session.save(employee);
//            session.getTransaction().commit();

            int myId = employee.getId();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee emp = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(emp);

            System.out.println("Успешно!");
        }
        finally {
            factory.close();
        }
    }
}
