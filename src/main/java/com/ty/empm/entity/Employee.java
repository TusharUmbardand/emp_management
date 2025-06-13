package com.ty.empm.entity;

import java.util.Objects;

public class Employee {

    private String name ;
    private int id ;
    private String job;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(job, employee.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, job, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}
