/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import entity.ExpenseManagement;
import java.util.Scanner;
import utils.Validation;

/**
 *
 * @author a
 */
public class Menu {
    Validation check = new Validation();

    private String[] options = {
        "Add an expense",
        "Display all expenses",
        "Delete an expense",
        "Quit"
    };
    
    private int getChoice(){
      Scanner sc = new Scanner(System.in);
        for (int i = 0; i < options.length;  i++) {
            System.out.println((i+1)+ ". " +options[i]);
        }
         return check.getInt("Your Choice:  ",1, options.length);
    }
    public void display(){
        ExpenseManagement m = new ExpenseManagement();
        int choice;
       
        do{
            System.out.println("========================Handy Expense program========================");
            choice = getChoice();
            switch(choice){
                case 1:
                    m.addExpense();
                    break;
                case 2:
                    m.display();
                     break;
                case 3:
                    m.delete();
                     break;
                case 4:
                     break;
            }
        }
        while(choice != 4);
    
    }
}
