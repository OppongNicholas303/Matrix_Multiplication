package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int matrixARow, matrixACol, matrixBRow, matrixBCol;


        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of matrixA row: ");

        matrixARow = sc.nextInt();

        System.out.println("Enter the size of matrixA column: ");
         matrixACol = sc.nextInt();

        int [][] matrixA = new int[matrixARow][matrixACol];

        do{
            System.out.println("Enter the size of matrixB row: ");
            matrixBRow = sc.nextInt();
        }while (matrixACol != matrixBRow);

        System.out.println("Enter the size of matrixB column: ");
        matrixBCol = sc.nextInt();

        int [][] matrixB = new int[matrixBRow][matrixBCol];



        inputFun(matrixA);
        inputFun(matrixB);


        System.out.println(Arrays.deepToString( matrixMultip(matrixA, matrixB)));
//        System.out.println(Arrays.toString(result[0]));
//        System.out.println(Arrays.toString(result[1]));


    }
    public static void inputFun(int[][] matrix){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                System.out.println("Enter matrixA column " + (i+1) + " i.e; " + "["+i+"]"+"["+j+"]" + " value");
                matrix[i][j] = sc.nextInt();
            }
        }
    }

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