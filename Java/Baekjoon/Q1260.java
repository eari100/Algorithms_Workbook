package Baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *@source: https://www.acmicpc.net/problem/1260
 *@classfication: dfs, bfs
 **/
public class Q1260 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeCnt = sc.nextInt();
        int lineCnt = sc.nextInt();
        int strNode = sc.nextInt();
        int[][] graph = new int[nodeCnt][nodeCnt];

        for(int i=0;i<lineCnt;i++) {
            int firstNode = sc.nextInt();
            int secondNode = sc.nextInt();
            graph[firstNode-1][secondNode-1] = 1;
            graph[secondNode-1][firstNode-1] = 1;
        }
        sc.close();

        boolean[] visited = new boolean[nodeCnt];
        visited[strNode-1] = true;
        System.out.print(strNode);

        for(int i=0;i<graph.length;i++) {
            if( graph[strNode-1][i] == 1 && !visited[i] ) {
                dfs(graph, visited, i);
            }
        }

        System.out.println();
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        System.out.print(strNode);
        visited[strNode-1] = true;

        for(int i=0;i<graph.length;i++) {
            if( graph[strNode-1][i] == 1 && !visited[i] ) {
                queue.add(i);
                visited[i] = true;
            }
        }
        while( !queue.isEmpty() ) {
            int poll = queue.poll();
            System.out.print(" "+(poll+1));
            for(int j=0;j<graph.length;j++) {
                if( graph[poll][j] == 1 && !visited[j] ) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    private static void dfs(int[][] graph, boolean[] visited, int node) {
        visited[node] = true;
        System.out.print(" "+(node+1));

        for(int i=0;i<graph.length;i++) {
            if( graph[node][i] == 1 && !visited[i] ) {
                dfs(graph, visited, i);
            }
        }
    }
}
