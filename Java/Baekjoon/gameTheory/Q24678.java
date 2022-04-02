package Baekjoon.gameTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/24678
 *@classfication: game theory
 **/
public class Q24678 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int x, y, z;
        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            if ((x % 2) + (y % 2) + (z % 2) <= 1)
                sb.append('R').append('\n');
            else
                sb.append('B').append('\n');
        }
        System.out.print(sb);
    }
}
