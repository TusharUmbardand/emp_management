package com.ty.empm.service;

import com.ty.empm.dao.EmployeeDAO;
import com.ty.empm.dao.implementation.EmployeeDAOImplementation;
import com.ty.empm.entity.Employee;

import java.sql.SQLException;

public class EmployeeService {

    EmployeeDAO employeeDAO = new EmployeeDAOImplementation();

    public void addEmployee(Employee emp) throws SQLException {
        employeeDAO.addEmp(emp);
    }
    public Employee getEmployeeId(int id){
       return  employeeDAO.getEmpById(id);
    }

    public Employee updateEmployee(int id ,double salary) throws SQLException {
        Employee employee = getEmployeeId(id);
        if(employee==null){
            return  null;
        }else {
            deleteEmployee(id);
            employee.setSalary(salary);
            addEmployee(employee);
            return employee;
        }

    }
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeDAO.deleteEmpById(id);
    }

}
