package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/13627 (Dangerous Dive)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.01.28 (O)
 **/
public class Q13627 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        boolean[] persons = new boolean[N+1];

        st = new StringTokenizer(br.readLine());

        br.close();

        for(int i=0;i<R;i++) {
            int idx = Integer.parseInt(st.nextToken());
            persons[idx] = true;
        }

        for(int i=1;i<persons.length;i++)
            if( !persons[i] ) result.append(i).append(' ');

        System.out.print(result.length() == 0 ? '*' : result);
    }
}
