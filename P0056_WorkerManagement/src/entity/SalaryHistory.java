/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;

/**
 *
 * @author a
 */
public class SalaryHistory {
    private String id, name, status;
    private double updatesalary;
    private int age;
    private LocalDate date;

    public SalaryHistory() {
    }

    public SalaryHistory(String id, String name, double updatesalary, int age, String status,  LocalDate date) {
        this.id = id;
        this.name = name;
        this.updatesalary = updatesalary;
        this.age = age;
        this.status = status;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getUpdatesalary() {
        return updatesalary;
    }

    public void setUpdatesalary(double updatesalary) {
        this.updatesalary = updatesalary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        return String.format("%s | %-8s | %2d | %-7.1f | %-4s | %-10s", id,name,age,updatesalary,status,date);
        
    }
    
}
