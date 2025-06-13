package com.ty.empm.dao.implementation;

import com.ty.empm.dao.EmployeeDAO;
import com.ty.empm.entity.Employee;

public class EmployeeDAOImplementation implements EmployeeDAO {

    @Override
    public boolean addEmp(Employee employee) {
        return false;
    }

    @Override
    public Employee getEmpById(int id) {
        return null;
    }

    @Override
    public void updateEmpSalary(int id, double salary) {

    }

    @Override
    public boolean deleteEmpById(int id) {
        return false;
    }
}
