package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/1652 (누울 자리를 찾아라)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.02.18 (O)
 **/
public class Q1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int 가로로_누울_수_있는_자리 = 0, 세로로_누울_수_있는_자리 = 0;
        char[][] graph = new char[N][N];

        for(int i=0;i<N;i++) {
            int tmp = 0;
            String line = br.readLine();

            for(int j=0;j<N;j++) {
                char marking = line.charAt(j);

                if(marking == '.') ++tmp;
                else if(marking == 'X') {
                    if(tmp > 1) ++가로로_누울_수_있는_자리;
                    tmp = 0;
                }

                graph[i][j] = marking;
            }

            if(tmp > 1) ++가로로_누울_수_있는_자리;
        }

        br.close();

        for(int i=0;i<graph[0].length;i++) {
            int tmp = 0;

            for(int j=0;j<graph.length;j++) {
                char marking = graph[j][i];

                if(marking == '.') ++tmp;
                else if(marking == 'X') {
                    if(tmp > 1) ++세로로_누울_수_있는_자리;
                    tmp = 0;
                }
            }

            if(tmp > 1) ++세로로_누울_수_있는_자리;
        }

        System.out.print(가로로_누울_수_있는_자리 + " " + 세로로_누울_수_있는_자리);
    }
}
