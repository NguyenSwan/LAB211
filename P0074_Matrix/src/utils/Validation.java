/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author a
 */
public class Validation {
    private Scanner sc = new Scanner (System.in);
    
    public int checkInputInt(String message, String error, int min, int max){
        do {            
            try {
                System.out.print(message);
                
                int number = Integer.parseInt(sc.nextLine());
                if(number >= min && number <= max){
                    return number;
                } else {
                    throw new NumberFormatException();
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (true);
    }
    
    public int[][] inputMatrix(int number){
        int row = checkInputInt("Enter Row Matrix " +number+ ": ", "Invalid!", 1, Integer.MAX_VALUE);
        int col = checkInputInt("Enter Column Matrix " + number + ": ", "Invalid!", 1, Integer.MAX_VALUE);
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = checkInputInt("Enter Matrix" + number + "[" + (i+1) +"][" + (j+1) +"]: ", "Values of matrix must be integer number!", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return matrix;
    }
    

}
