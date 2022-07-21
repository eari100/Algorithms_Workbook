package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/18513 (샘터)
 * @classfication: bfs
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.20 (O~X, 힌트 열람, 트리님 힌트)
 **/
public class Q18513 {
    public static void main(String[] args) throws IOException {
        long result = 0;
        int houseCnt = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        Queue<long[]> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            int water = Integer.parseInt(st.nextToken());
            queue.offer(new long[]{water, 0});
            set.add(water);
        }

        br.close();

        while( houseCnt < K+N ) {
            long[] poll = queue.poll();
            result += poll[1];
            ++houseCnt;

            long left = poll[0]-1;
            if( !set.contains((int)left) ) {
                queue.offer(new long[]{left, poll[1]+1});
                set.add((int) left);
            }

            long right = poll[0]+1;
            if( !set.contains((int)right) ) {
                queue.offer(new long[]{right, poll[1]+1});
                set.add((int) right);
            }
        }

        System.out.print(result);
    }
}
