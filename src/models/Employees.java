/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;



/**
 *
 * @author User
 */
public class Employees {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String hireDate;
    private String jId;
    private int salary;
    private double pct;
    private int mId;
    private int dId;

    public Employees(){
    }

    public Employees(int id, String firstName, String lastName, String email, String phone, String hireDate, String jId, int salary, double pct, int mId, int dId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.jId = jId;
        this.salary = salary;
        this.pct = pct;
        this.mId = mId;
        this.dId = dId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getjId() {
        return jId;
    }

    public void setjId(String jId) {
        this.jId = jId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getPct() {
        return pct;
    }

    public void setPct(double pct) {
        this.pct = pct;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }
    
    public void enter(){
        System.out.println("| EMPLOYEE ID: " + id  + " | FIRST NAME: " + firstName + " | LAST NAME: " + lastName + " | EMAIL: " + email + " | PHONE NUMBER: " + phone + " | HIRE DATE: " + hireDate + " | JOB ID: " + jId + " | SALARY: " + salary + " | COMMISSION PCT: " + pct + " | MANAGER ID: " + mId + " | DEPARTMENT ID: " + dId + " |");
    }
}
