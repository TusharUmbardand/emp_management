package com.ty.empm.dao;

import com.ty.empm.entity.Employee;

import java.sql.SQLException;

public interface EmployeeDAO {

    public void addEmp(Employee employee) throws SQLException;
    public Employee getEmpById(int id);

    public boolean deleteEmpById(int id) throws SQLException;



}
