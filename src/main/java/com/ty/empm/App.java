package com.ty.empm;

import com.ty.empm.controller.EmployeeController;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        System.out.println("WELCOME TO EMPLOYEE MANAGEMENT");
        boolean flage = true;
        int choice ;
        Scanner sc = new Scanner(System.in);
        while (flage){
            System.out.println("1.ADD EMPLOYEE \n2.SEARCH EMPLOYEE BY ID \n3.UPDATE SALARY \n4.DELETE EMPLOYEE BY ID \n5.EXIT");
          try{  choice = sc.nextInt();
            switch (choice){
                case 1 : employeeController.addEmp();
                break;
                case 2 : employeeController.getEmployeeById();
                break;
                case 3 : employeeController.updateEmployee();
                break;
                case 4 : employeeController.deleteEmployeeById();
                break;
                case 5 : flage = false;
                break;
                default:
                    System.out.println("GIVE VALID INSTRUCTION");

            }
            sc.nextLine();
          }catch (InputMismatchException e){
              System.out.println("GIVE VALID INPUT");
              sc.nextLine();
          }
        }
    }
}
