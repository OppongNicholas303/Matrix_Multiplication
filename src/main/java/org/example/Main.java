package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int matrixARow, matrixACol, matrixBRow, matrixBCol;

        Scanner sc = new Scanner(System.in);

        // Input rows and columns for Matrix A
        System.out.println("Enter the size of matrixA row: ");
        matrixARow = sc.nextInt();
        System.out.println("Enter the size of matrixA column: ");
        matrixACol = sc.nextInt();

        // Initialize Matrix A with user-defined dimensions
        int [][] matrixA = new int[matrixARow][matrixACol];

        // Input elements for Matrix A
        inputFun(matrixA, "matrix A");

        // Ensure Matrix B rows match Matrix A columns for multiplication compatibility
        do{
            System.out.println("Enter the size of matrixB row, let it match matrixA column: ");
            matrixBRow = sc.nextInt();
        }while (matrixACol != matrixBRow);

        // Input columns for Matrix B
        System.out.println("Enter the size of matrixB column: ");
        matrixBCol = sc.nextInt();

        // Initialize Matrix B result with user-defined dimensions
        int [][] matrixB = new int[matrixBRow][matrixBCol];

        // Input elements for Matrix B
        inputFun(matrixB, "matrix B");

        System.out.println("Matrix A x Matrix B is : " + Arrays.deepToString( matrixMultip(matrixA, matrixB)));
    }

    // Method to take matrix input from the user
    public static void inputFun(int[][] matrix, String matrixName){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                System.out.println("Enter " + matrixName + " column " + (i+1) + " i.e; " + "["+i+"]"+"["+j+"]" + " element");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(matrixName + " : " + Arrays.deepToString(matrix));
    }

    // Method to perform matrix multiplication
    public static int[][] matrixMultip(int[][] matrixA, int[][] matrixB){

        int [][] matrixC = new int[matrixA.length][matrixB[0].length];

        for(int i=0; i<matrixA.length; i++){
            int [] col = matrixA[i];
            for(int j=0; j<matrixB[0].length; j++){
                matrixC[i][j] =0;
                for (int k=0; k<matrixB.length; k++){
                    matrixC[i][j] += col[k] * matrixB[k][j];
                }
            }
        }

        return matrixC;
    }
}