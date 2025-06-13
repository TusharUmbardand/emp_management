package com.ty.empm.controller;

import com.ty.empm.dao.EmployeeDAO;
import com.ty.empm.entity.Employee;
import com.ty.empm.service.EmployeeService;
import com.ty.empm.util.DataValidation;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeController {

    private EmployeeService employeeService = new EmployeeService();
    Scanner sc = new Scanner(System.in);
    public void addEmp(){
        try {
        System.out.println("Enter name");
        String name = sc.nextLine();
        if(!DataValidation.nameCheck(name)){
            System.out.println("INVALID NAME");
            return;
        }
        System.out.println("Enter id");
        int id = sc.nextInt();

        System.out.println("Enter job");
        String job = sc.next();
        System.out.println("Enter salary");
        double salary = sc.nextDouble();
        Employee emp = new Employee();
        emp.setSalary(salary);
        emp.setName(name);
        emp.setJob(job);
        emp.setId(id);

            employeeService.addEmployee(emp);
        } catch (SQLException e) {
            System.out.println("SOMETHING WENT WRONG");
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
    }

    public Employee getEmployeeById(){
        System.out.println("ENTER ID");
        int id = sc.nextInt();
     Employee emp = employeeService.getEmployeeId(id);
     if(emp!=null){
         System.out.println(emp);
     }else {
         System.out.println("EMPLOYEE WITH GIVEN ID IS NOT PRESENT");
     }
     return emp;

    }

   public void updateEmployee(){
       try {
       System.out.println("ENTER ID");
       int id = sc.nextInt();
       System.out.println("ENTER UPDATED SALARY");
       double salary = sc.nextDouble();
       Employee emp = employeeService.updateEmployee(id,salary);
       if(emp!=null){
           System.out.println("UPDATE EMPLOYEE DETAILS");
           System.out.println(emp);
       }
       else {
           System.out.println("EMPLOYEE WITH GIVEN ID IS NOT PRESENT");
       }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }catch (InputMismatchException e){
           sc.nextLine();
           System.out.println("ENTER VALID INPUT");
       }

   }
    public boolean deleteEmployeeById(){
        System.out.println("ENTER ID");
        boolean isDeleted = false;
        try {
            int id = sc.nextInt();
          isDeleted=  employeeService.deleteEmployee(id);
        } catch (SQLException e) {
            System.out.println("EMPLOYEE WITH GIVEN ID IS NOT PRESENT");
        }catch (InputMismatchException e){
            System.out.println("ENTER A VALID ID");
        }
        return isDeleted;
    }


}
