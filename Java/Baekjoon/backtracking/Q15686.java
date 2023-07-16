package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/15686 (치킨 배달)
 * @classfication: backtracking + bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.07.16 (O)
 **/
public class Q15686 {
    static int minChickenDist = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<ChickenHouse> chickenHouses = new ArrayList<>();
    static int[] nX = {-1, 1, 0, 0};
    static int[] nY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int node = Integer.parseInt(st.nextToken());
                map[i][j] = node;

                if(node == 2) {
                    chickenHouses.add(new ChickenHouse(i, j));
                }
            }
        }

        br.close();

        backtracking(0, 0, chickenHouses.size() - M, map);

        System.out.print(minChickenDist);
    }

    private static void backtracking(int searchIdx, int depth, int maxDepth, int[][] map) {
        if(depth == maxDepth) {
            int chickenDist = 0;

            for(int i=0;i<map.length;i++) {
                for(int j=0;j<map.length;j++) {
                    if(map[i][j] == 1) {
                        boolean[][] copyVisited = new boolean[map.length][map[0].length];
                        chickenDist += getChickenDist(i, j, map, copyVisited);
                    }
                }
            }

            minChickenDist = Math.min(minChickenDist, chickenDist);
            return;
        }

        if(chickenHouses.size() - searchIdx < maxDepth - depth) return;

        for(int i=searchIdx;i<chickenHouses.size();i++) {
            ChickenHouse chickenHouse = chickenHouses.get(i);

            int x = chickenHouse.getX();
            int y = chickenHouse.getY();
            map[x][y] = 0;
            backtracking(i+1,depth+1, maxDepth, map);
            map[x][y] = 2;
        }
    }

    private static int getChickenDist(int houseX, int houseY, int[][] map, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{houseX, houseY, 0});

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            int dist1 = poll[2];

            for(int i=0;i<nX.length;i++) {
                int x2 = x1 + nX[i];
                int y2 = y1 + nY[i];
                int dist2 = dist1 + 1;

                if(x2 < 0 || x2 >= map.length || y2 < 0 || y2 >= map.length) continue;
                if(visited[x2][y2]) continue;

                int node = map[x2][y2];

                if(node == 2) return dist2;

                visited[x2][y2] = true;
                queue.offer(new int[]{x2, y2, dist2});
            }
        }

        return -1;
    }

    public static class ChickenHouse {
        public int x;
        public int y;

        public ChickenHouse(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
