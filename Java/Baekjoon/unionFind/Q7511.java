package Baekjoon.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/7511 (소셜 네트워킹 어플리케이션)
 * @classfication: union find
 * @문제 푼 날짜 (자력으로 풂?): 23.12.20 (O)
 **/
public class Q7511 {
    static final String Scenario ="Scenario ";
    static int[] parents;

    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=1;i<=t;i++) {
            result.append(Scenario).append(i).append(':').append('\n');

            int n = Integer.parseInt(br.readLine());
            parents = new int[n];

            for(int j=1;j<n;j++) {
                parents[j] = j;
            }

            int k = Integer.parseInt(br.readLine());

            for(int j=0;j<k;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                union(n1, n2);
            }

            int m = Integer.parseInt(br.readLine());

            for(int j=0;j<m;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                result.append(find(n1) == find(n2) ? 1 : 0).append('\n');
            }

            result.append('\n');
        }

        br.close();

        System.out.print(result);
    }

    private static void union(int n1, int n2) {
        int r1 = find(n1), r2 = find(n2);

        if(r1 < r2)
            parents[r2] = r1;
        else if(r1 > r2)
                parents[r1] = r2;
    }

    private static int find(int n) {
        if(parents[n] == n)
            return n;

        return parents[n] = find(parents[n]);
    }
}
