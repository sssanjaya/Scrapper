/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.fiows;

import com.leapfrog.fiows.dao.EmployeeDAO;
import com.leapfrog.fiows.dao.StudentDAO;
import com.leapfrog.fiows.dao.impl.EmployeeDAOImpl;
import com.leapfrog.fiows.dao.impl.StudentDAOImpl;
import com.leapfrog.fiows.entity.Student;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author user
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        StudentDAO stuDAO=new StudentDAOImpl();
        try {
            stuDAO.loadFromFile("students.csv");
            stuDAO.getAll().forEach(e->{
                System.out.println(e.toString());
            });
          
            stuDAO.insert(new Student(stuDAO.getAll().size() +1, "AddTest", "kjshada", "k@g.com", "123654", true));
            stuDAO.export("Students1.csv");
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
    }
    
}
