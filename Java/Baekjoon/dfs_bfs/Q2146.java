package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2146 (다리 만들기)
 * @classification: bfs
 * @문제 푼 날짜 (자력솔?): 24.01.02 (X, 메모리 관리하기)
 **/
public class Q2146 {
    static int[][] map;
    static final int LAND = 1, SEA = 0, tmpLand = -1;
    static int landIndex = 1, minDist = 10000;;
    static final int[] nX = {-1, 1, 0, 0};
    static final int[] nY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0;i<n;i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                int obj = Integer.parseInt(row.nextToken());

                if(obj == LAND) {
                    map[i][j] = tmpLand;
                }
            }
        }

        br.close();

        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                if(map[i][j] == -1) {
                    assignLandIndex(i, j);
                    ++landIndex;
                }
            }
        }

        for(int i=1;i<landIndex;i++) {
            int[][] copyOfMap = new int[map.length][map[0].length];

            for(int j=0;j<map.length;j++) {
                copyOfMap[j] = Arrays.copyOf(map[j], map[j].length);
            }

            minDist = Math.min(minDist, searchDist(i, copyOfMap));
        }

        System.out.print(minDist);
    }

    private static void assignLandIndex(int x1, int y1) {
        map[x1][y1] = landIndex;

        for(int i=0;i<nX.length;i++) {
            int x2 = x1+nX[i], y2 = y1+nY[i];

            if(x2 < 0 || x2 >= map.length || y2 < 0 || y2 >= map[0].length)
                continue;

            if(map[x2][y2] == SEA) continue;
            if(map[x2][y2] == landIndex) continue;

            assignLandIndex(x2, y2);
        }
    }

    private static int searchDist(int landIndex, int[][] copyOfMap) {
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<copyOfMap.length;i++) {
            for(int j=0;j<copyOfMap[0].length;j++) {
                if(copyOfMap[i][j] == landIndex) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();

            int x1 = poll[0], y1 = poll[1], dist1 = poll[2];

            if(dist1 == minDist) {
                return dist1;
            }

            for(int i=0;i<nX.length;i++) {
                int x2 = x1+nX[i], y2 = y1+nY[i], dist2 = dist1+1;

                if(x2 < 0 || x2 >= copyOfMap.length || y2 < 0 || y2 >= copyOfMap[0].length)
                    continue;

                int obj = copyOfMap[x2][y2];

                if(landIndex == obj)
                    continue;

                if(obj == SEA) {
                    copyOfMap[x2][y2] = landIndex;
                    queue.offer(new int[]{x2, y2, dist2});
                } else {
                    return dist1;
                }
            }
        }

        return 10_000;
    }
}
