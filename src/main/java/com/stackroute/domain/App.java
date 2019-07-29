package com.stackroute.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("beans.xml");
       SimpleJdbcDemo simpleJdbcDemo=applicationContext.getBean("simpleJdbcDemo",SimpleJdbcDemo.class);

        simpleJdbcDemo.insertEmployeeDetails();
        simpleJdbcDemo.updateEmployeeDetails();
        simpleJdbcDemo.readEmployeeDetails();
        simpleJdbcDemo.deleteEmployeeDetails();

    }
}
