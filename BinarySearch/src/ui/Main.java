/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import entity.BinarySearch;
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
        scanner.nextLine();
        
        System.out.println("Enter search value: ");
        int search = scanner.nextInt();
        
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = new Random().nextInt(number);
        }
        
        BinarySearch binary = new BinarySearch();
        binary.bubbleSort(array);
        
        System.out.println("Sorted array: ");
        binary.displayArray(array);
        
        int index = binary.binarySearch(array, search);
        if (index == -1) {
            System.out.println("\nCan not found key!");
        } else {
            System.out.println("\nFound " + search + " at index " + index);
        }
    }
    
}
