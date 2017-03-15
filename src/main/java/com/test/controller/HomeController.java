package com.test.controller;

import com.test.models.Employees;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class HomeController {
    @RequestMapping("/")
    public ModelAndView helloWorld()
    {
        return new
                ModelAndView("welcome","message","Hello World");

    }

    @RequestMapping("employeesList")
    public ModelAndView employeeList() throws SQLException, ClassNotFoundException {
        ArrayList<Employees> employeesList = getEmployees();
        return new
                ModelAndView("employeesList","eList",employeesList);
    }

    public ArrayList<Employees> getEmployees() throws ClassNotFoundException, SQLException {
        String selectEmployees = "select employeeid,firstname,lastname,title,birthdate,salary from employees where salary>1900";
        String url = "jdbc:mysql://localhost:3306/northwind";
        String userName = "root";
        String password = "admin";
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection(url,userName,password);

            Statement st = c.createStatement();
            ResultSet rs =st.executeQuery(selectEmployees);
            ArrayList<Employees> employeeList = new ArrayList();

            while(rs.next() ==true)
            {
                String employeeID = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String title = rs.getString(4);
                String birthDate = rs.getString(5);
                String salary = rs.getString(6);
                Employees temp = new Employees(employeeID,firstName,lastName,title,birthDate,salary);

                employeeList.add(temp);
            }
            return employeeList;

        }catch(Exception ex)
        {
            return null;
        }

    }


}
