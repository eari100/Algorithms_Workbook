package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2573 (빙산)
 * @classfication: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.10.09 (X, 빙하가 음수가 되는 반례를 찾지 못함.)
 **/
// todo: 빙하가 존재하는 좌표를 하나만 저장하면 성능이 올라간다
public class Q2573 {
    static final int[] nX = {-1, 1, 0, 0};
    static final int[] nY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long year = 0;

        int[][] earth = new int[N][M];
        ArrayList<int[]> memo = new ArrayList<>();

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int height = Integer.parseInt(st.nextToken());
                earth[i][j] = height;

                if(height > 0)
                    memo.add(new int[]{i, j});
            }
        }

        while( !isTwiceLump(earth, memo) ) {
            if(memo.size() == 0) {
                year = 0;
                break;
            }
            ++year;

            ArrayList<Integer> meltingSizeList = new ArrayList<>();

            for(int m=0;m<memo.size();m++) {
                int[] direction = memo.get(m);
                int x1 = direction[0];
                int y1 = direction[1];
                int meltingSize = 0;

                for(int i=0;i<nX.length;i++) {
                    int x2 = x1 + nX[i];
                    int y2 = y1 + nY[i];

                    if(x2 < 0 || x2 >= earth.length || y2 < 0 || y2 >= earth[0].length)
                        continue;

                    if(earth[x2][y2] == 0)
                        ++meltingSize;
                }

                meltingSizeList.add(meltingSize);
            }

            ArrayList<int[]> memo2 = new ArrayList<>();
            for(int i=0;i<memo.size();i++) {
                int[] direction = memo.get(i);
                int x = direction[0];
                int y = direction[1];

                earth[x][y] -= Math.min(meltingSizeList.get(i), earth[x][y]);

                if(earth[x][y] > 0) {
                    memo2.add(new int[]{x, y});
                }
            }

            memo = memo2;
        }

        System.out.print(year);
        br.close();
    }

    private static boolean isTwiceLump(int[][] earth, ArrayList<int[]> memo) {
        int lump = 0;
        boolean[][] visited = new boolean[earth.length][earth[0].length];

        for(int[] direction : memo) {
            int initX = direction[0];
            int initY = direction[1];

            if(visited[initX][initY]) continue;

            ++lump;
            Queue<int[]> queue = new LinkedList<>();
            visited[initX][initY] = true;
            queue.offer(direction);

            while( !queue.isEmpty() ) {
                int[] poll = queue.poll();
                int x1 = poll[0];
                int y1 = poll[1];

                for(int i=0;i<nX.length;i++) {
                    int x2 = x1 + nX[i];
                    int y2 = y1 + nY[i];

                    if(x2 < 0 || x2 >=earth.length || y2 < 0 || y2 >= earth[0].length)
                        continue;

                    if(visited[x2][y2])
                        continue;

                    if(earth[x2][y2] == 0)
                        continue;

                    visited[x2][y2] = true;
                    queue.offer(new int[]{x2, y2});
                }
            }
        }

        return lump >= 2;
    }
}
