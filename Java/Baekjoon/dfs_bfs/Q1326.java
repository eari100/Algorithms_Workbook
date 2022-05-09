package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/1326 (폴짝폴짝)
 *@classfication: bfs
 **/
public class Q1326 {
    static int[] visited;
    static int[] jumps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        jumps = new int[cnt];
        visited = new int[cnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<cnt;i++)
            jumps[i] = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int str = Integer.parseInt(st2.nextToken()) - 1;
        int end = Integer.parseInt(st2.nextToken()) - 1;

        br.close();

        bfs(str, end);
        System.out.print(visited[end] == 0 ? -1 : visited[end]);
    }

    private static void bfs(int str, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(str);

        while(!queue.isEmpty()) {
            int poll = queue.poll();

            for(int i=poll+jumps[poll];i<jumps.length;i+=jumps[poll]) {
                if(visited[i] == 0) {
                    visited[i] = visited[poll]+1;

                    if(i != end) queue.offer(i);
                    else return;
                }
            }

            for(int i=poll-jumps[poll];i>=0;i-=jumps[poll]) {
                if(visited[i] == 0) {
                    visited[i] = visited[poll]+1;

                    if(i != end) queue.offer(i);
                    else return;
                }
            }
        }
    }
}
