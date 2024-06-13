/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import entity.TaskManagement;
import java.util.Scanner;
import utils.Validation;

/**
 *
 * @author a
 */
public class Menu {
    Validation check = new Validation();

    private String[] options = {
        "Add Task",
        "Delete task",
        "Display Task",
        "exit"
    };
    
    private int getChoice(){
      Scanner sc = new Scanner(System.in);
        for (int i = 0; i < options.length;  i++) {
            System.out.println((i+1)+ ". " +options[i]);
        }
         return check.getInt("Your Choice:  ",1, options.length);
    }
    public void display(){
        TaskManagement m = new TaskManagement();
        int choice;
       
        do{
            System.out.println("========================Task program========================");
            choice = getChoice();
            switch(choice){
                case 1:
                    m.addTask();
                    break;
                case 2:
                    m.deleteTask();
                     break;
                case 3:
                    m.display();
                     break;
                case 4:
                     break;
            }
        }
        while(choice != 4);
    
    }
}
