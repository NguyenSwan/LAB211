package controller;

import util.Validation;

public class Menu {
    public static int chooseInputOption(){
        Validation validation = new Validation();
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete.");
        System.out.println("4. Report.");
        System.out.println("5. Exit");
        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program)");
        int option = validation.inputOption(1, 5);
        return option;
    }
}