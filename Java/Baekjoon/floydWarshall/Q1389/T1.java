package Baekjoon.floydWarshall.Q1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T1 {
    static int[][] gragh;
    static int INF = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        gragh = new int[N][N];

        for(int i[] : gragh)
            Arrays.fill(i, INF);

        for(int i=0;i<M;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st2.nextToken()) - 1;
            int to = Integer.parseInt(st2.nextToken()) - 1;

            gragh[from][to] = gragh[to][from] = 1;
        }
        br.close();

        floydWarshall();

        System.out.print(minValIdx());
    }

    private static void floydWarshall() {
        for(int k=0;k<gragh.length;k++) {
            for(int i=0;i<gragh.length;i++) {
                for(int j=0;j<gragh.length;j++) {
                    gragh[i][j] = Math.min(gragh[i][j], gragh[i][k] + gragh[k][j]);
                }
            }
        }
    }

    private static int minValIdx() {
        int idx = 100;
        int sum = 100;

        for(int i=0;i<gragh.length;i++) {
            int sumN = 0;

            for(int j=0;j<gragh.length;j++) {
                sumN += gragh[i][j];
            }

            if(sum > sumN) {
                idx = i+1;
                sum = sumN;
            } else if(sum == sumN && idx > i+1) {
                idx = i+1;
                sum = sumN;
            }
        }

        return idx;
    }
}
