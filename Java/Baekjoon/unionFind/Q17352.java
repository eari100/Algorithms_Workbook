package Baekjoon.unionFind;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/17352 (여러분의 다리가 되어 드리겠습니다!)
 * @classfication: union-find
 * @문제 푼 날짜 (자력으로 풂?): 23.12.14 (O)
 **/
public class Q17352 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        parents = new int[n];

        for(int i=0;i<parents.length;i++)
            parents[i] = i;

        for(int i=0;i<n-2;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;

            union(n1, n2);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int node : parents) {
            set.add(find(node)+1);
        }

        StringBuilder bridge = new StringBuilder();

        for(int node : set) {
            bridge.append(node).append(' ');
        }

        bw.write(bridge.toString());
        br.close();
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
        if(n == parents[n])
            return n;

        return parents[n] = find(parents[n]);
    }
}
