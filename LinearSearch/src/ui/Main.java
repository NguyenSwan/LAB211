/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import entity.LinearSearch;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author a
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of array: ");
        int number = scanner.nextInt();
//        scanner.nextLine();
        
        System.out.println("Enter search value: ");
        int key = scanner.nextInt();
        
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = new Random().nextInt(number);
        }
        LinearSearch linear = new LinearSearch();
        System.out.print("The array: ");
        linear.display(array);
        
        int firstIndex = linear.linearSearch(array, key);
        if(firstIndex == -1){
            System.out.println("Can not found value!");
        } else{
            System.out.println("Found " + key + " at index: " + firstIndex);
        }
    }
    
}
