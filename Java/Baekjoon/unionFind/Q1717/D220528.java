package Baekjoon.unionFind.Q1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1717 (집합의 표현)
 * @classification: union-find
 * @reference: https://www.youtube.com/watch?v=AMByrd53PHM&feature=emb_title (동빈나 - 합집합 찾기)
 * @문제 푼 날짜 (자력으로 풂?): 22.05.28 (X)
 **/
public class D220528 {
    static int[] parents;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];

        for(int i=0;i<n+1;i++)
            parents[i] = i;

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(x == 0) {
                union(a, b);
            } else if(x == 1) {
                sb.append(eqParents(a,b) ? "YES" : "NO").append('\n');
            }
        }
        br.close();

        System.out.print(sb);
    }

    private static int find(int x) {
        if(x == parents[x]) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    private static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if(pA != pB) {
            if(pA < pB) {
                parents[pB] = pA;
            } else {
                parents[pA] = pB;
            }
        }
    }

    private static boolean eqParents(int a, int b) {
        return find(a) == find(b);
    }
}
