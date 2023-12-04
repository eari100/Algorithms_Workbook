package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * @source: https://www.acmicpc.net/problem/17266 (어두운 굴다리)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.12.04 (O)
 **/
public class Q17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] nodes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int highest = 0;

        br.close();

        highest = Math.max(nodes[0], N - nodes[nodes.length-1]);

        for(int i=1;i<nodes.length;i++) {
            int prev = nodes[i-1];
            int curr = nodes[i];
            int dist = curr - prev;

            int div = dist / 2;
            int mod = dist % 2 == 0 ? 0 : 1;

            highest = Math.max(highest, div + mod);
        }

        System.out.print(highest);
    }
}
