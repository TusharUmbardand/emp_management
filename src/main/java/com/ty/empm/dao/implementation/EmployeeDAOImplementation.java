package com.ty.empm.dao.implementation;

import com.ty.empm.dao.EmployeeDAO;
import com.ty.empm.entity.Employee;
import com.ty.empm.util.ConnectionPool;

import java.sql.*;

public class EmployeeDAOImplementation implements EmployeeDAO {

    Connection connection = ConnectionPool.getConnectionObject();

    @Override
    public void addEmp(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee VALUES(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, employee.getName());
        ps.setInt(2,employee.getId());
        ps.setString(3,employee.getJob());
        ps.setDouble(4,employee.getSalary());
        ps.execute();
    }

    @Override
    public Employee getEmpById(int id) {
        Employee emp = null;

        String sql = "SELECT * FROM employee WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()==true){
                int empId = rs.getInt(2);
                String name = rs.getString(1);
                String job = rs.getString(3);
                double salary = rs.getDouble(4);
                emp = new Employee();
                emp.setId(empId);
                emp.setName(name);
                emp.setJob(job);
                emp.setSalary(salary);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return emp;
    }




    @Override
    public boolean
    deleteEmpById(int id) throws SQLException {
        String sql = "DELETE from employee WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        int isDeleted = ps.executeUpdate();
        return isDeleted==1 ? true : false;
    }
}
