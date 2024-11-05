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

        int [][] matrixC = new int[matrixARow][matrixACol];

        inputFun(matrixA);
        inputFun(matrixB);



        System.out.println(Arrays.toString(matrixA[0]));
        int [][] result = matrixMultip(matrixA, matrixB, matrixC);

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

    public static int[][] matrixMultip(int[][] matrixA, int[][] matrixB, int[][] matrixC){
        System.out.println("MatrixA "+ Arrays.deepToString(matrixA));
        System.out.println("MatrixB "+Arrays.deepToString(matrixB));

        for(int i=0; i<matrixA.length; i++){
            int []row = matrixA[i];


            for(int j=0; i<matrixB[0].length; j++){
                int temp = 0;
                int [] col = new int[matrixB.length];

               for(int k = 0; i<matrixB.length; k++){
                   System.out.println(j);
                   col[k] = matrixB[k][j];
               }

               for(int t =0; t<col.length; t++ ){
                   temp += row[t]+col[t];
               }
               matrixC[i][j] = temp;
            }

        }
        return matrixC;
    }
}