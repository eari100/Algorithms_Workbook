package Baekjoon.unionFind.Q1717;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1717 (집합의 표현)
 * @classification: union-find
 * @문제 푼 날짜 (자력으로 풂?): 23.12.14 (O)
 **/
public class D231214 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        final String YES = "YES", NO = "NO";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];

        for(int i=0;i<n+1;i++)
            parents[i] = i;

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());

            int action = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if(action == 0) {
                union(n1, n2);
            } else if(action == 1) {
                bw.write(find(n1) == find(n2) ? YES : NO);
                bw.newLine();
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void union(int n1, int n2) {
        int root1 = find(n1);
        int root2 = find(n2);

        if(root1 < root2) {
            parents[root2] = root1;
        } else if(root1 > root2) {
            parents[root1] = root2;
        }
    }

    private static int find(int n) {
        if(parents[n] == n)
            return n;

        return parents[n] = find(parents[n]);
    }
}
