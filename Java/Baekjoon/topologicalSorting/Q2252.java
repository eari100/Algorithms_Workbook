package Baekjoon.topologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2252 (줄 세우기)
 * @classification: topology sort
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.18 (X)
 **/
public class Q2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[] input = new int[n + 1];
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for(int i=1;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
            ++input[end];

            graph[str].add(end);
        }

        br.close();

        for(int i=1;i<=n;i++) {
            if(input[i] == 0) {
                queue.add(i);
            }
        }

        while( !queue.isEmpty() ) {
            int poll = queue.poll();
            result.append(poll).append(' ');

            for(int next : graph[poll]) {
                --input[next];

                if(input[next] == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.print(result);
    }
}
