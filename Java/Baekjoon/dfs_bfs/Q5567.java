package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList[] network = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        visited[1] = true;

        for(int i=1;i<network.length;i++) {
            network[i] = new ArrayList();
        }

        for(int i=0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            network[str].add(end);
            network[end].add(str);
        }

        br.close();

        System.out.print(bfs(network, visited, 1));
    }

    private static int bfs(ArrayList<Integer>[] network, boolean[] visited, int x){
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 0});

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int depth = poll[1];

            if(depth == 2) continue;

            for(int node : network[x1]) {
                if( !visited[node] ) {
                    ++count;
                    visited[node] = true;
                    queue.offer(new int[]{node, depth+1});
                }
            }
        }

        return count;
    }
}
