/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import entity.Fibonacci;

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
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("The 45 sequence fibonacci: ");
        fibonacci.fibonacciRecursive(45, 0, 1);
    }
    
}
