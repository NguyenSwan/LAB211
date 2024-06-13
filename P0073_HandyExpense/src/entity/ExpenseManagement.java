/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import utils.Validation;

/**
 *
 * @author a
 */
public class ExpenseManagement {
    List<Expense> eList = new ArrayList<Expense>();
    Validation check = new Validation();
    Scanner sc = new Scanner(System.in);
    
    public void addExpense(){
        System.out.println("------ Add an expense ------");
        int id = 1;
        if(!eList.isEmpty()){
            id = eList.get(eList.size()-1).getId()+1;
        }
        
        Date dateInput = check.getDate("Enter Date: ", "Date invalid", "dd/MM/yyyy");
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MMM-yyyy");
        String date = simpleDate.format(dateInput);
        
        double amount = check.getDouble("Enter amount: ", 0, Double.MAX_VALUE);
        
        String content = null;
        do {            
            try {
                System.out.println("Enter Content: ");
                content = sc.nextLine();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        } while (content.equals(""));
        
        Expense expense = new Expense(id, date, amount, content);
        eList.add(expense);
    }
    
    public void display(){
        if(eList.isEmpty()){
            System.out.println("List is empty. Please try again");
        } else {
            System.out.println("------- Display all expense -------");
            
            double total = 0;
            System.out.println("ID\tDate\t\t\tAmount of money\t\tContent");
            for (Expense expense : eList) {
                System.out.println(expense.getId()+"\t"+expense.getDate()+"\t\t"
                +expense.getNumber()+"\t\t\t"+expense.getContent());
                
                total += expense.getNumber();
            }
            System.out.println(" Total: " +total);
        }
    }
    
    public void delete(){
        if(eList.isEmpty()){
            System.out.println("List is empty. Please try again");
        } else {
            System.out.println("--------Delete an expense--------");
            
            int deleteId = check.getInt("Enter ID: ", 1, Integer.MAX_VALUE);
            
            boolean isExist = false;
            
            for (Expense expense : eList) {
                if (expense.getId() ==  deleteId) {
                    eList.remove(expense);
                    System.out.println("Dalete an expense successful");
                    isExist = true;
                    break;
                }
            }
            if(!isExist){
                System.out.println("Delete an expense fail");
            }
        }
    }
}
