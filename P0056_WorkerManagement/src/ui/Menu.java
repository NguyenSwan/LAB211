/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import entity.Management;
import java.util.Scanner;
import utils.Validation;

/**
 *
 * @author a
 */
public class Menu {
    Validation check = new Validation();
    
    private String[] ops = {
       "Add Worker: ",
       "Up Salary: ",
       "Down Salary: ",
       "Display information salary",
       "Exit"
    };
    
    private int getChoice(){
      Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ops.length;  i++) {
            System.out.println((i+1)+ ". " +ops[i]);
        }
         return check.getInt("Your Choice:  ",1, ops.length);
    }
    public void display(){
        Management m = new Management();
        int choice;
       
        do{
            System.out.println("========================Worker Management========================");
            choice = getChoice();
            switch(choice){
                case 1:
                     System.out.println("------------------------Add Worker------------------------");
                    m.addWorker();
                    break;
                case 2:
                    System.out.println("------------------------Up/Down Salary------------------------");
                    m.updateWorker(1);
                     break;
                case 3:
                    System.out.println("------------------------Up/Down Salary------------------------");
                    m.updateWorker(2);
                     break;
                case 4:
                     System.out.println("------------------------Display Information Salary------------------------");
                     System.out.printf("%-5s  %-10s  %-5s  %-20s  %-5s  %-10s", "Code", "Name", "Age", "Salary", "Status", "Date");
                     System.out.println("");
                     m.getInformation();
                     break;
                case 5:
                    break;
            }
        }
        while(choice != 5);
    
    }
}
