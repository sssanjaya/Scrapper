/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.fiows.dao.impl;

import com.leapfrog.fiows.dao.EmployeeDAO;
import com.leapfrog.fiows.entity.Employee;
import com.leapfrog.fiows.util.CSVHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author user
 */
public class EmployeeDAOImpl implements EmployeeDAO{
    
    private List<Employee> empList=new ArrayList<>();
    @Override
    public void insert(Employee t) {
        empList.add(t);
    }

    @Override
    public List<Employee> getAll() {
        return empList;
    }

    @Override
    public void loadFromFile(String fileName) throws IOException {
        
        CSVHandler.read(fileName).forEach(r->{
            StringTokenizer tokens=new StringTokenizer(r,",");
            
            if(tokens.countTokens() >=6){
                Employee empl=new Employee();
                empl.setId(Integer.parseInt(tokens.nextToken()));
                empl.setFirstname(tokens.nextToken());
                empl.setLastName(tokens.nextToken());
                empl.setEmail(tokens.nextToken());
                empl.setContactNo(tokens.nextToken());
                empl.setStatus(Boolean.parseBoolean(tokens.nextToken()));
            
                insert(empl);
            }
        });
    }

    @Override
    public void export(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
