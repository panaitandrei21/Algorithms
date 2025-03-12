package org.example;

public class RotateMatrix {
    public static void main(String[] args) {
        int n = 3, m = 3 ;
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = i + j;
            }
        }
        rotateMatrix(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.printf(matrix[i][j] + " ");
            System.out.println();
        }
    }

    private static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top= matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last - offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }
}
