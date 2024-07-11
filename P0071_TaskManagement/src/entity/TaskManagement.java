/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import utils.Validation;

/**
 *
 * @author a
 */
public class TaskManagement {
    List<Task> listTask = new ArrayList<>();
    Validation check = new Validation();
    
    public void addTask(){
        System.out.println("-----------Add Task-----------");
        int id = 1;
        if(!listTask.isEmpty()){
            id = listTask.get(listTask.size()-1).getId()+1;
        }
        String name = check.getString("[A-Za-z ]", "Requirement Name: ");
        
        int typeId = check.getInt("Task Type: ", 1, 4);
        
        String date = check.getDate("Date: ", "Invalid date format", "dd-MM-yyyy");
        
    double from = 0;
    while (true) {
        from = check.getDouble("From: ", 8.0, 17.5);
        if (from % 0.5 == 0) {
            break;
        } else {
            System.out.println("From time must be in the format of 8.5, 9.0, 9.5,..., 17.5. Please try again.");
        }
    }
    
    double to;
    while (true) {
        to = check.getDouble("To: ", 8.0, 17.5);
        if (to % 0.5 == 0 && to >= from) {
            break;
        } else if (to < from) {
            System.out.println("To time must be greater than or equal to From time. Please try again.");
        } else {
            System.out.println("To time must be in the format of 8.5, 9.0, 9.5,..., 17.5. Please try again.");
        }
    }
//        double to = check.getDouble("To: ", 8.0, 17.5);


        
        String assignee = check.getString("[a-zA-Z ]", "Assignee: ");
        String reviewer = check.getString("[a-zA-Z ]", "Reviewer: ");
        
        Task task = new Task(id, name, typeId, date, from, to, assignee, reviewer);
        listTask.add(task);
    }
         


    public void display(){
//        System.out.println("------------------Task-----------------");
//        for (Task task : listTask) {
//            System.out.println(task.toString());
//        }
        if(listTask.isEmpty()){
            System.out.println("List is empty. Please try again");
        } else {
            System.out.println("------------------Task-----------------");
            System.out.printf("%-5s %-20s %-20s %-20s %-20s %-20s %-20s", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            System.out.println();
            for (Task task : listTask) {
           //    System.out.println("ID\t\tName\t\tTask Type\t\tDate\t\tTime\t\tAssignee\t\tReviewer");
               System.out.println(task.toString());
               }
          }
    }
    
    public void deleteTask(){
        System.out.println("--------------Del Task------------");
        int deleteId = check.getInt("ID: ", 1, Integer.MAX_VALUE);
        boolean idExist = false;
        
        for (Task task : listTask) {
            if(task.getId() == deleteId){
                listTask.remove(task);
                idExist = true;
                System.out.println("Delete successful");
                break;
            }
        }
        if(!idExist){
            System.out.println("Id not found. Delete fail");
        }
    }
}
