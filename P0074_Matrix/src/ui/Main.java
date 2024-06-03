/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import entity.Matrix;
import utils.Validation;

/**
 *
 * @author a
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        System.out.println("=======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        
        Validation input = new Validation();
        int[][] matrix1, matrix2, result;
        Matrix resultMatrix = new Matrix();
        int choice = input.checkInputInt("Your choice: ", "Invalid!", 1, 4);
        
        switch(choice){
            case 1:
                System.out.println("-------Addition------");
                matrix1 = input.inputMatrix(1);
                matrix2 = input.inputMatrix(2);
                result = resultMatrix.add(matrix1, matrix2);
                if(result == null){
                    System.out.println("Cannot add 2 matrix");
                } else {
                    System.out.println("----------Result-----------");
                    resultMatrix.displayMatrix(matrix1);
                    System.out.println("+");
                    resultMatrix.displayMatrix(matrix2);
                    System.out.println("=");
                    resultMatrix.displayMatrix(result);
                }
                break;
            case 2:
                System.out.println("-------Subtraction------");
                matrix1 = input.inputMatrix(1);
                matrix2 = input.inputMatrix(2);
                result = resultMatrix.sub(matrix1, matrix2);
                if(result == null){
                    System.out.println("Cannot sub 2 matrix");
                } else {
                    System.out.println("----------Result-----------");
                    resultMatrix.displayMatrix(matrix1);
                    System.out.println("-");
                    resultMatrix.displayMatrix(matrix2);
                    System.out.println("=");
                    resultMatrix.displayMatrix(result);
                }
                break;
            case 3:
                System.out.println("-------Multiplication------");
                matrix1 = input.inputMatrix(1);
                matrix2 = input.inputMatrix(2);
                result = resultMatrix.mul(matrix1, matrix2);
                if(result == null){
                    System.out.println("Can not multi 2 matrix");
                } else {
                    System.out.println("----------Result-----------");
                    resultMatrix.displayMatrix(matrix1);
                    System.out.println("*");
                    resultMatrix.displayMatrix(matrix2);
                    System.out.println("=");
                    resultMatrix.displayMatrix(result);
                }
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
}
