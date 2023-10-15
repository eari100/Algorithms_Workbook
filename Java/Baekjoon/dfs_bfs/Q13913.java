package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/13913 (숨바꼭질 4)
 * @classification: bfs + backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.10.16 (X, bfs + 역추적)
 **/
public class Q13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] load = new int[100_000 + 1];
        int[] parent = new int[100_000 + 1];

        Arrays.fill(load, 100_000 + 1);
        load[N] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while( !queue.isEmpty() ) {
            int index = queue.poll();
            int cost = load[index];

            if(index*2 != 0) {
                if(index*2 >= 0 && index*2 < load.length) {
                    if(load[index*2] > cost + 1) {
                        load[index*2] = cost + 1;
                        parent[index*2] = index;

                        if(index*2 == K) {
                            break;
                        }

                        queue.offer(index*2);
                    }
                }
            }

            if(index+1 >= 0 && index+1 < load.length) {
                if(load[index+1] > cost + 1) {
                    load[index+1] = cost + 1;
                    parent[index + 1] = index;

                    if(index+1 == K) {
                        break;
                    }

                    queue.offer(index + 1);
                }
            }

            if(index-1 >= 0 && index-1 < load.length) {
                if(load[index-1] > cost + 1) {
                    load[index-1] = cost + 1;
                    parent[index - 1] = index;

                    if(index-1 == K) {
                        break;
                    }

                    queue.offer(index - 1);
                }
            }
        }

        ArrayList<Integer> log = new ArrayList<>();
        int index = K;

        while(index != N) {
            index = parent[index];
            log.add(index);
        }

        result.append(load[K]).append('\n');

        for(int i=log.size()-1;i>=0;i--)
            result.append(log.get(i)).append(' ');

        result.append(K);

        System.out.println(result);
        br.close();
    }
}
