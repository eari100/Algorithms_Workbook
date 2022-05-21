package Baekjoon.sort;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2947 (나무 조각)
 * @classfication: bubble sort
 **/
public class Q2947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int[] trees = new int[5];

        for(int i=0;i<5;i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        sort(trees);
    }

    private static void sort(int[] trees) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<4;i++) {
            if(trees[i] > trees[i+1]) {
                int swap = trees[i];
                trees[i] = trees[i+1];
                trees[i+1] = swap;

                sb.append(trees[0]+" "+trees[1]+" "+trees[2]+" "+trees[3]+" "+trees[4]).append('\n');
            }
        }

        System.out.print(sb);

        String result = trees[0]+" "+trees[1]+" "+trees[2]+" "+trees[3]+" "+trees[4];

        if( !result.equals("1 2 3 4 5") ) {
            sort(trees);
        }
    }
}
