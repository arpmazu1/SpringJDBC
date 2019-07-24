package com.stackroute.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //application context for accessing bean.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        EmployeeDao dao = context.getBean("edao",EmployeeDao.class);

        //Creating a Table Employee
        dao.createTable();

        //Inserting values inside the Table Employee
        dao.updateTable(new Employee(2,"Sophie",21,"Female"));
        dao.updateTable(new Employee(23,"Kit",28,"Male"));
        dao.updateTable(new Employee(34,"Maisie",18,"Female"));
        dao.updateTable(new Employee(12,"Cole",23,"Male"));
        dao.updateTable(new Employee(9,"Bradd",41,"Male"));

       // Deleting value from the Table Employee
            dao.deletefromTable(2);

        //Reading Table Employee
        List<Employee> list=dao.readTable();
        //displaying the details
        for(Employee e:list)
            System.out.println(e);
    }
}
