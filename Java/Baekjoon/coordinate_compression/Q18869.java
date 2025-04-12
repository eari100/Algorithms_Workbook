package Baekjoon.coordinate_compression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/18869 (멀티버스 Ⅱ)
 * @classification: coordinate compression
 * @문제 푼 날짜 (자력으로 풂?): 25.04.12 (X)
 **/
public class Q18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] saved = new int[m][n];
        int answer = 0;

        for(int i=0;i<m;i++) {
            ArrayList<Integer> l = new ArrayList<>();
            ArrayList<Integer> sorted_l = new ArrayList<>();
            HashMap<Integer, Integer> sorted_hash = new HashMap<>();
            int rank = 1;

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                int num = Integer.valueOf(st.nextToken());
                l.add(num);
                sorted_l.add(num);
            }

            Collections.sort(sorted_l);

            for(int j=0;j<n;j++) {
                sorted_hash.put(sorted_l.get(j), rank++);
            }

            for(int j=0;j<n;j++) {
                saved[i][j] = sorted_hash.get(l.get(j));
            }

            for(int j=0;j<i;j++) {
                boolean is_match = true;

                for(int k=0;k<n;k++) {
                    if(saved[i][k] != saved[j][k]) {
                        is_match = false;
                        break;
                    }
                }

                if(is_match) {
                    ++answer;
                }
            }
        }

        br.close();

        System.out.print(answer);
    }
}
