package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/16930 (달리기)
 * @classfication: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.03.17 (X, n칸 이동하는 bfs: 더 짧은 시간에 해당 구간을 지난 기록이 있다면 해당 방향으로 더 이상 가지 않도록 한다)
 **/
public class Q16930 {
    static int N, M, K;
    static int[][] gym;
    static boolean[][] visited;
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        gym = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            String row = br.readLine();
            for(int j=0;j<M;j++) {
                char obj = row.charAt(j);
                int objToInt = 0;

                if(obj == '.') objToInt = 0;
                else if(obj == '#') objToInt = -1;

                gym[i][j] = objToInt;
            }
        }

        st = new StringTokenizer(br.readLine());

        br.close();

        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;
        int endX = Integer.parseInt(st.nextToken()) - 1;
        int endY = Integer.parseInt(st.nextToken()) - 1;

        bfs(startX, startY, endX, endY);
        int result = gym[endX][endY];

        System.out.print(result == 0 ? -1 : result);
    }

    private static void bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();

            int x1 = poll[0];
            int y1 = poll[1];

            for(int i=0;i<nx.length;i++) {
                for(int j=1;j<K+1;j++) {
                    int x2 = x1 + nx[i] * j;
                    int y2 = y1 + ny[i] * j;

                    if(x2 < 0 || x2 > N-1 || y2 < 0 || y2 > M-1) break;
                    if(gym[x2][y2] == -1) break;

                    if(!visited[x2][y2]) {
                        gym[x2][y2] = gym[x1][y1] + 1;

                        if(x2 == endX && y2 == endY) return;

                        visited[x2][y2] = true;
                        queue.offer(new int[]{x2, y2});

                    // 더 짧은 시간에 해당 구간을 지난 기록이 있다면 해당 방향으로 더 이상 가지 않도록 한다.
                    } else if(gym[x2][y2] <= gym[x1][y1]) break;
                }
            }
        }
    }
}
