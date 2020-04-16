package com.稀疏数组;

public class SparseArray {

    public static void main(String[] args) {


        int[][] ints = new int[11][11];
        ints[1][2] = 1;
        ints[2][3] = 2;


//        for (int[] row : ints) {
//            for (int data : row) {
//                System.out.printf("%d\t", data);
//            }
//            System.out.println();
//        }
//
//        System.out.println("=============");

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.printf("%d\t", ints[i][j]);
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
//                System.out.printf("%d\t", ints[i][j]);
                if (ints[i][j] != 0) {
                    sum++;
                }
            }
        }

        int sparseArray[][] = new int[sum + 1][3];

        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int col = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
//                System.out.printf("%d\t", ints[i][j]);
                if (ints[i][j] != 0) {
                    col++;
                    sparseArray[col][0] = i;
                    sparseArray[col][1] = j;
                    sparseArray[col][2] = ints[i][j];
                }
            }
        }
        System.out.println("=====================");
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.printf("%d\t", sparseArray[i][j]);
            }
            System.out.println();
        }


    }
}
