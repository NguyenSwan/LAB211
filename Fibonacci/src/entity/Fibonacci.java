/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author a
 */
public class Fibonacci {
    public int fibonacciRecursive(int number, int previous, int current){
        if(number < 2){
            return previous;
        }
        int next = previous + current;
        System.out.print(previous + ", ");
        return fibonacciRecursive(number - 1, current, next);
    }
}
