package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int matrixARow, matrixACol, matrixBRow, matrixBCol;

        Scanner sc = new Scanner(System.in);

        // Input rows and columns for Matrix A
        System.out.print("Enter the size of matrixA row: ");
        if(!sc.hasNextInt()) System.out.println("Invalid integer restart the Application!");
        matrixARow = sc.nextInt();

        System.out.print("Enter the size of matrixA column: ");
        if(!sc.hasNextInt()) System.out.println("Invalid integer restart the Application!");
        matrixACol = sc.nextInt();

        // Initialize Matrix A with user-defined dimensions
        int [][] matrixA = new int[matrixARow][matrixACol];

        // Input elements for Matrix A
        inputMatrixElements(matrixA, "matrix A");

        // Input rows and columns for Matrix B
        // Ensure Matrix B rows match Matrix A columns for multiplication compatibility
        do{
            System.out.print("Enter the size of matrixB row, let it match matrixA column: ");
            if(!sc.hasNextInt()) System.out.println("Invalid integer restart the Application!");
            matrixBRow = sc.nextInt();
        }while (matrixACol != matrixBRow);

        // Input columns for Matrix B
        System.out.print("Enter the size of matrixB column: ");
        if(!sc.hasNextInt()) System.out.println("Invalid integer restart the Application!");
        matrixBCol = sc.nextInt();


        // Initialize Matrix B result with user-defined dimensions
        int [][] matrixB = new int[matrixBRow][matrixBCol];

        // Input elements for Matrix B
        inputMatrixElements(matrixB, "matrix B");

        int [] [] resultOfMatrixC = matrixMultiplication(matrixA, matrixB);

        //Printing Matrix C
        System.out.println("Matrix A x Matrix B is ");
        for(int i = 0; i<resultOfMatrixC.length; i++){
            for(int j = 0; j<resultOfMatrixC[0].length; j++){
                System.out.print(resultOfMatrixC[i][j] + "  ");
            }
            System.out.println();

        }

    }

    // Method to take matrix element from the user
    public static void inputMatrixElements(int[][] matrix, String matrixName){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                System.out.print("Enter " + matrixName + " row " + (i+1) + " i.e; " + "["+i+"]"+"["+j+"]" + " element: ");
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(matrixName + " : " + Arrays.deepToString(matrix));
    }

    // Method to perform matrix multiplication
    public static int[][] matrixMultiplication(int[][] matrixA, int[][] matrixB){

        int [][] matrixC = new int[matrixA.length][matrixB[0].length];

        for(int i=0; i<matrixA.length; i++){    // A  12, 2, 4      B   2, 2   C 30  32
            int [] row = matrixA[i];            //    10, 1, 1          1, 2     22  23
            for(int j=0; j<matrixB[0].length; j++){  //                 1, 1
                matrixC[i][j] =0;
                for (int k=0; k<matrixB.length; k++){
                    matrixC[i][j] += row[k] * matrixB[k][j];
                }
            }
        }

        return matrixC;
    }
}