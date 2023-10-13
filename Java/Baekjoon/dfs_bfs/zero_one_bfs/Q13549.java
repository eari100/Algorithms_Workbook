package Baekjoon.dfs_bfs.zero_one_bfs;

import java.io.*;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/13549 (숨바꼭질 3)
 * @classification: 0-1 bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.10.13 (O)
 **/
// todo: 다익스트라, dfs (https://www.acmicpc.net/source/23545875) 로 풀어볼 것
public class Q13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        LinkedList<Integer> queue = new LinkedList<>();
        int[] load = new int[100_000 + 1];

        Arrays.fill(load, 100_000 + 1);
        load[N] = 0;
        queue.offer(N);

        while( !queue.isEmpty() ) {
            int num = queue.poll();
            int cost = load[num];

            int num3 = num * 2;
            if(num3 >= 0 && num3 < load.length) {
                if(load[num3] > cost) {
                    load[num3] = cost;

                    if(num3 == K) break;

                    queue.addFirst(num3);
                }
            }

            int num1 = num - 1;

            if(num1 >= 0 && num1 < load.length) {
                if(load[num1] > cost + 1) {
                    load[num1] = cost + 1;

                    if(num1 == K) break;

                    queue.offer(num1);
                }
            }

            int num2 = num + 1;

            if(num2 >= 0 && num2 < load.length) {
                if(load[num2] > cost + 1) {
                    load[num2] = cost + 1;

                    if(num2 == K) break;

                    queue.offer(num2);
                }
            }
        }

        System.out.print(load[K]);
    }
}