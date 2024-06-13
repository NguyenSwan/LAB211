/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.Validation;

/**
 *
 * @author a
 */
public class Management {
    private Scanner sc = new Scanner(System.in);
    private List<Worker> wlist;
    private List<SalaryHistory> sList;
    Validation check = new Validation();
    
    public Management() {
        wlist = new ArrayList<>();
        sList = new ArrayList<>();
    }

    
    public void addWorker(){
        
       String id,name,workLocation;
       int age;
       double salary;
       
       id = check.getCode("Enter Code: ", "Id should be not exist and not null ", wlist, 1);
        System.out.print("Enter Name: ");
       
        name = sc.nextLine();
       
        age = check.getInt("Enter Age: ",18, 50);
        
        salary = check.getDouble("Enter Salary: ", 0.000001,Double.MAX_VALUE);
        
        System.out.print("Enter work location: ");
        workLocation = sc.nextLine();
        
         wlist.add(new Worker(id, name, age, salary, workLocation));
        
            
    }
    
    public void updateWorker(int mode){
          if (wlist.isEmpty()) {
            System.err.println("List empty.");
            return;
          }
        String id = check.getCode("Enter Code: ","NOT found ID in Database", wlist, 2);
        
        double update = 0;
        double money = check.getDouble("Enter Salary: ",0.0000001,Double.MAX_VALUE);
        Worker o = check.getWorker(id, wlist);
         
         if(o == null) {
             System.out.println("Worker not found!");
             return;
         }
         String status = "";
         if(mode==1){
             update = o.getSalary()+money;
             status = "UP";
         }
         
         
         else if(mode == 2){
            if(o.getSalary()>0){
                //check 
                if(o.getSalary() <= money){
                    System.out.println("Salary cannot be less than 0 ");
                    return;
                }
              update = o.getSalary()-money;
              
                 status = "DOWN";
            }
         }
        o.setSalary(update);
        
          sList.add(new SalaryHistory(id,o.getName(), o.getSalary(), o.getAge(), status,java.time.LocalDate.now()));
        }
    
    public void getInformation(){
        display(sList);
        
    }
    
    public void display(List list){
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
