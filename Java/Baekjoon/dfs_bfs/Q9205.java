package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * @source: https://www.acmicpc.net/problem/9205 (맥주 마시면서 걸어가기)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.07.08 (X)
 **/
// todo: 플로이드 와샬로 풀어볼 것
public class Q9205 {
    static final int maxBeerCnt = 20;
    static final int oneBeerDist = 50;

    static final int maxBeerDist = maxBeerCnt * oneBeerDist;
    static final String happy = "happy";
    static final String sad = "sad";
    
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        L1: while(T-- > 0) {
            int covCnt = Integer.parseInt(br.readLine());
            int nodeCnt = 2+covCnt;
            int[][] distArr = new int[nodeCnt][2];
            ArrayList<Integer>[] graph = new ArrayList[nodeCnt];

            for(int i=0;i<nodeCnt;i++) {
                graph[i] = new ArrayList<>();
                st = new StringTokenizer(br.readLine());

                distArr[i][0] = Integer.parseInt(st.nextToken());
                distArr[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<nodeCnt;i++) {
                for(int j=0;j<nodeCnt;j++) {
                    if(i == j) continue;

                    int x1 = distArr[i][0];
                    int y1 = distArr[i][1];
                    int x2 = distArr[j][0];
                    int y2 = distArr[j][1];

                    if(getDist(x1, y1, x2, y2) <= maxBeerDist) {
                        graph[i].add(j);
                        graph[j].add(i);
                    }
                }
            }

            boolean[] visited = new boolean[nodeCnt];
            visited[0] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);

            while( !queue.isEmpty() ) {
                int startIndex = queue.poll();

                ArrayList<Integer> network = graph[startIndex];

                for(int endIndex : network) {
                    if(visited[endIndex]) continue;

                    if(endIndex == nodeCnt - 1) {
                        result.append(happy).append('\n');
                        continue L1;
                    }

                    visited[endIndex] = true;
                    queue.offer(endIndex);
                }
            }


            result.append(sad).append('\n');
        }
        
        br.close();

        System.out.print(result);
    }
    
    private static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
