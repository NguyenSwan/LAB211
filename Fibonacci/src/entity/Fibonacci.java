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
    public int fibonacciRecursion(int n){
        if(n == 0 || n == 1){
            return  n;
        } else {
            return (fibonacciRecursion(n-1)+fibonacciRecursion(n-2));
        }
    }
}
