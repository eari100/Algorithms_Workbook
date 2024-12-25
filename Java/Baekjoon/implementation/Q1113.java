package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/1113 (수영장 만들기)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.12.26 (테케 보고 풀었음.. 업솔빙하라면 빡구현이라 고생할 것 같음)
 **/
public class Q1113 {
    static int water = 0;
    static final int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] board;
    static boolean[][] visited;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[2] - p1[2]);
    static int _max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++) {
            String s = br.readLine();

            for(int j=0;j<m;j++) {
                int num = Character.getNumericValue(s.charAt(j));
                board[i][j] = num;
                pq.offer(new int[]{i, j, num});
                _max = Math.max(_max, num);
            }
        }

        br.close();

        while(!pq.isEmpty()) {
            int[] poll = pq.poll();
            int x1 = poll[0], y1 = poll[1], num1 = board[x1][y1];

            if(num1 == _max || visited[x1][y1]) continue;
            visited[x1][y1] = true;

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{x1, y1});

            boolean isAdd = true;
            int tmpWater = 0;
            int minWall = _max;
            int visitedCnt = 0;
            ArrayList<int[]> vLog = new ArrayList<>();

            while(!q.isEmpty()) {
                int[] poll2 = q.poll();
                int x2 = poll2[0], y2 = poll2[1], num2 = board[x2][y2];
                tmpWater += num2;
                ++visitedCnt;

                for(int[] move : moves) {
                    int x3 = x2 + move[0], y3 = y2 + move[1];

                    // board 바깥으로 넘침
                    if(x3 < 0 || x3 >= board.length || y3 < 0 || y3 >= board[0].length) {
                        isAdd = false;
                        continue;
                    }

                    int num3 = board[x3][y3];

                    if(num3 <= num1) {
                        if( !visited[x3][y3] ) {
                            q.offer(new int[]{x3, y3});
                        }

                        if(num3 < num1) {
                            vLog.add(new int[]{x3, y3});
                        }
                    } else  {
                        minWall = Math.min(minWall, num3);
                    }

                    visited[x3][y3] = true;
                }
            }

            if(isAdd) {
                water += visitedCnt * minWall - tmpWater;
            } else {
                for(int[] arr : vLog) {
                    visited[arr[0]][arr[1]] = false;
                }
            }
        }

        System.out.print(water);
    }
}
