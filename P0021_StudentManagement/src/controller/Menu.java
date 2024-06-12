package controller;

import util.Validation;

public class Menu {
    public static int chooseInputOption(){
        Validation validation = new Validation();
        System.out.println("1. Create student.");
        System.out.println("2. Find student.");
        System.out.println("3. Update of Delete.");
        System.out.println("4. Display report.");
        System.out.println("5. Exit.");
        int option = validation.inputOption(1, 5);
        return option;
    }
}
