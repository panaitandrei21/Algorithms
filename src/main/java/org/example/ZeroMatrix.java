package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ZeroMatrix {
    public static void main(String[] args) {
        int n = 3, m = 3 ;
        int[][] matrix;
        matrix = new int[][]{{1, 0, 3},
                             {1, 2, 3},
                             {1, 2, 3}};
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                matrix[i][j] = i + j;
//            }
//        }
        zeroMatrix(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.printf(matrix[i][j] + " ");
            System.out.println();
        }
    }

    private static void zeroMatrix(int[][] matrix) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> rows = new HashSet<>();

        //O(N^2)
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        //O(Nr of column to put 0 on which is max n * )
        for(Integer col : columns) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
        for(Integer row : rows) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[row][i] = 0;
            }
        }

    }
}
