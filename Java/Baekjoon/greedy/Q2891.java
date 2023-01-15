package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2891 (카약과 강풍)
 * @classfication: greedy
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 23.01.15 (O)
 **/
public class Q2891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] teams = new int[N+2];
        Arrays.fill(teams, 1);

        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<S;i++) {
            int index = Integer.parseInt(st.nextToken());
            --teams[index];
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<R;i++) {
            int index = Integer.parseInt(st.nextToken());
            ++teams[index];
        }

        br.close();

        for(int i=1;i<teams.length;i++) {
            if(teams[i] == 0) {
                if(teams[i-1] == 2)
                    teams[i-1] = 1;
                else if(teams[i+1] == 2)
                    teams[i+1] = 1;
                else
                    ++result;
            }
        }

        System.out.print(result);
    }
}
