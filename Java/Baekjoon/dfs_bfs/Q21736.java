package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/21736 (헌내기는 친구가 필요해)
 * @classfication: bfs
 * @문제 푼 날짜 (자력으로 풂?): 24.02.17 (O)
 **/
public class Q21736 {
    static final char EMPTY = 'O', PERSON = 'P', DOYEON = 'I', WALL = 'X';
    static char[][] map;
    static boolean[][] visited;
    static final int[] nX = {-1, 1, 0, 0};
    static final int[] nY = {0, 0, -1, 1};
    static int[] doyeonCoordinate = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++) {
            String row = br.readLine();

            for(int j=0;j<m;j++) {
                char obj = row.charAt(j);
                map[i][j] = obj;

                if(obj == DOYEON) {
                    doyeonCoordinate[0] = i;
                    doyeonCoordinate[1] = j;
                }
            }
        }

        br.close();

        int personCnt = findPerson();
        System.out.print(personCnt == 0 ? "TT" : personCnt);
    }

    private static int findPerson() {
        int personCnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(Arrays.copyOf(doyeonCoordinate, 2));
        visited[doyeonCoordinate[0]][doyeonCoordinate[1]] = true;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0], y1 = poll[1];

            for(int i=0;i<nX.length;i++) {
                int x2 = x1 + nX[i], y2 = y1 + nY[i];

                if(x2 < 0 || x2 >= map.length || y2 < 0 || y2 >= map[0].length) continue;
                if(visited[x2][y2]) continue;
                if(map[x2][y2] == WALL) continue;

                if(map[x2][y2] == PERSON) ++personCnt;

                queue.offer(new int[]{x2, y2});
                visited[x2][y2] = true;
            }
        }

        return personCnt;
    }
}
