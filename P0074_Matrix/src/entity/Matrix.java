/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author a
 */
public class Matrix {
    private int row;
    private int col;
    private int[][] matrix;

    public int getRow(int[][] matrix) {
        return matrix.length;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol(int[][] matrix) {
        return matrix[0].length;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    
    public int[][] add(int[][] matrix1, int[][] matrix2) throws Exception{
        int row1 = getRow(matrix1);
        int col1 = getCol(matrix1);
        int row2 = getRow(matrix2);
        int col2 = getCol(matrix2);
        if (row1 != row2 && col1 != col2) {
            throw new Exception("Row and column matrix 1 must be equal row and column matrix 2");
        }
        int row = getRow(matrix1);
        int col = getCol(matrix1);
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    
    public int[][] sub(int[][] matrix1, int[][] matrix2) throws Exception{
        int row1 = getRow(matrix1);
        int col1 = getCol(matrix1);
        int row2 = getRow(matrix2);
        int col2 = getCol(matrix2);
        if (row1 != row2 && col1 != col2) {
            throw new Exception("Row and column matrix 1 must be equal row and column matrix 2");
        }
        int row = getRow(matrix1);
        int col = getCol(matrix1);
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    
    public int[][] mul(int[][] matrix1, int[][] matrix2) throws Exception{
        int row1 = getRow(matrix1);
        int col1 = getCol(matrix1);
        int row2 = getRow(matrix2);
        int col2 = getCol(matrix2);
        if(col1 != row2){
            throw new Exception("Cols of matrix 1 must be equal rows of matrix 2");
        }
        int[][] result = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
    
    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
}
