package Baekjoon.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/16562 (친구비)
 * @classification: union-find
 * @문제 푼 날짜 (자력솔?): 23.12.30 (O)
 **/
public class Q16562 {
    static int[] expense;
    static Integer[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), money = Integer.parseInt(st.nextToken());
        expense = new int[n];
        parents = new Integer[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) {
            expense[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1, n2 = Integer.parseInt(st.nextToken()) - 1;

            union(n1, n2);
        }

        br.close();

        int sum = 0;

        boolean[] visited = new boolean[n];

        for(int i : parents) {
            int root = find(i);
            if( visited[root] ) continue;

            visited[root] = true;

            sum += expense[root];
        }

        System.out.print(sum > money ? "Oh no" : sum);
    }

    private static void union(int n1, int n2) {
        int r1 =  find(n1), r2 = find(n2);

        if(expense[r1] <= expense[r2]) {
            parents[r2] = r1;
        } else if(expense[r1] > expense[r2]) {
            parents[r1] = r2;
        }
    }

    private static int find(int n) {
        if(n == parents[n])
            return n;

        return parents[n] = find(parents[n]);
    }
}
