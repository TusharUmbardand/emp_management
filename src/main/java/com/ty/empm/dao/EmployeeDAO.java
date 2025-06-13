package com.ty.empm.dao;

import com.ty.empm.entity.Employee;

public interface EmployeeDAO {

    public boolean addEmp(Employee employee);
    public Employee getEmpById(int id);
    public void updateEmpSalary(int id , double salary);
    public boolean deleteEmpById(int id);



}
