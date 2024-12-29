package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/16935 (배열 돌리기 3)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.12.30 (O)
 **/
public class Q16935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][m];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<r;i++) {
            int type = Integer.parseInt(st.nextToken());
            int height = matrix.length;
            int width = matrix[0].length;
            int halfHeight = height / 2;
            int halfWidth = width / 2;

            if(type == 1) {
                for(int j=0;j<halfHeight;j++) {
                    for(int k=0;k<width;k++) {
                        swapMatrix(matrix, j, k, height-1-j, k);
                    }
                }
            } else if(type == 2) {
                for(int j=0;j<height;j++) {
                    for(int k=0;k<halfWidth;k++) {
                        swapMatrix(matrix, j, k, j, width-1-k);
                    }
                }
            } else if(type == 3) { // 우측 90도 회전
                int[][] copyMatrix = new int[width][height];

                for(int j=0;j<width;j++) {
                   for(int k=0;k<height;k++) {
                       copyMatrix[j][height-1-k] = matrix[k][j];
                   }
                }

                matrix = new int[width][height];
                copyMatrix(matrix, copyMatrix);
            } else if(type == 4) { // 좌측 90도 회전
                int[][] copyMatrix = new int[width][height];

                for(int j=0;j<width;j++) {
                    for(int k=0;k<height;k++) {
                        copyMatrix[width-1-j][k] = matrix[k][j];
                    }
                }

                matrix = new int[width][height];
                copyMatrix(matrix, copyMatrix);
            } else if(type == 5) { // 1->2->3->4
                int[][] copyMatrix = new int[height][width];

                for(int j=0;j<halfHeight;j++) {
                    for(int k=0;k<halfWidth;k++) {
                        copyMatrix[j][k] = matrix[j + halfHeight][k];
                        copyMatrix[j][k + halfWidth] = matrix[j][k];
                        copyMatrix[j + halfHeight][k + halfWidth] = matrix[j][k + halfWidth];
                        copyMatrix[j + halfHeight][k] = matrix[j + halfHeight][k + halfWidth];
                    }
                }

                copyMatrix(matrix, copyMatrix);
            } else if(type == 6) { // 1->4->3->2
                int[][] copyMatrix = new int[height][width];

                for(int j=0;j<halfHeight;j++) {
                    for(int k=0;k<halfWidth;k++) {
                        copyMatrix[j][k] = matrix[j][k + halfWidth];
                        copyMatrix[j][k + halfWidth] = matrix[j + halfHeight][k + halfWidth];
                        copyMatrix[j + halfHeight][k + halfWidth] = matrix[j + halfHeight][k];
                        copyMatrix[j + halfHeight][k] = matrix[j][k];
                    }
                }

                copyMatrix(matrix, copyMatrix);
            }
        }

        br.close();

        writeMatrix(result, matrix);
        System.out.print(result);
    }

    private static void copyMatrix(int[][] original, int[][] copy) {
        for(int i=0;i<copy.length;i++) {
            for(int j=0;j<copy[i].length;j++) {
                original[i][j] = copy[i][j];
            }
        }
    }

    private static void swapMatrix(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    private static void writeMatrix(StringBuilder sb, int[][] matrix) {
        for(int[] arr : matrix) {
            for(int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
        }
    }
}
