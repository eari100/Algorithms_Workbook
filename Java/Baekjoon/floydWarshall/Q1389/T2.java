package Baekjoon.floydWarshall.Q1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1389 (케빈 베이컨의 6단계 법칙)
 * @classfication: floyd-warshall
 * @문제 푼 날짜 (자력으로 풂?): 23.09.05(X, 인접 인수 제일 바깥에 둘 것, 업솔빙 실팽)
 **/
public class T2 {
    final static int INF = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] network = new int[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(i == j)
                    network[i][j] = 0;
                else
                    network[i][j] = INF;
            }
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            network[a][b] = 1;
            network[b][a] = 1;
        }

        br.close();

        for(int k=0;k<N;k++) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    network[i][j] = Math.min(network[i][j], network[i][k] + network[k][j]);
                }
            }
        }

        System.out.println(Arrays.deepToString(network));

        int minDist = INF;
        int minIndex = 0;

        for(int i=0;i<network.length;i++) {
            int dist = 0;
            for(int d : network[i]) {
                dist += d;
            }

            if(minDist > dist) {
                minDist = dist;
                minIndex = i+1;
            }
        }

        System.out.print(minIndex);
    }
}
