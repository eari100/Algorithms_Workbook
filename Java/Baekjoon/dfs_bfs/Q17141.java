package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/17141 (연구소 2)
 * @classfication: bfs, backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.08.30 (X, 구현 설계는 맞았으나 time 변수 초기화를 잘못 잡아서 틀림)
 **/
// todo: bfs를 queue 대신 dequeue 로 성능을 올릴 것
public class Q17141 {
    final static int[] nX = {-1, 1, 0, 0};
    final static int[] nY = {0, 0, -1, 1};
    static int M;
    static ArrayList<int[]> virusPlace = new ArrayList<>();
    static int minTime = Integer.MAX_VALUE;
    static int spaceCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];
        spaceCnt = N * N;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++) {
                int obj = Integer.parseInt(st.nextToken());

                if(obj == 1) {
                    board[i][j] = -1;
                    --spaceCnt;
                } else if(obj == 2) {
                    virusPlace.add(new int[]{i, j});
                }
            }
        }

        br.close();

        makeVirusBoard(0, board, 0, new ArrayList<>());

        System.out.print(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    private static void makeVirusBoard(int depth, int[][] board, int strIndex, List<int[]> virusList) {
        if(M == depth) {
            Queue<int[]> queue = new LinkedList<>(virusList);
            int[][] deepCopyBoard = new int[board.length][board[0].length];

            for(int i=0;i<board.length;i++) {
                for(int j=0;j<board[0].length;j++) {
                    deepCopyBoard[i][j] = board[i][j];
                }
            }

            minTime = Math.min(minTime, fullVirusTime(deepCopyBoard, queue));
            return;
        }

        for(int i=strIndex;i<virusPlace.size();i++) {
            int[] vp = virusPlace.get(i);
            board[vp[0]][vp[1]] = 1;
            virusList.add(new int[]{vp[0], vp[1]});
            makeVirusBoard(depth+1, board, i+1, virusList);
            board[vp[0]][vp[1]] = 0;
            virusList.remove(virusList.size() - 1);
        }
    }

    private static int fullVirusTime(int[][] board, Queue<int[]> queue) {
        int time = 1; // 설정한대로 제대로 초기화 할 것
        int sc = queue.size(); // space cnt

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];

            for(int i=0;i<nX.length;i++) {
                int x2 = x1 + nX[i];
                int y2 = y1 + nY[i];

                if(x2 < 0 || x2 >= board.length || y2 < 0 || y2 >= board[0].length)
                    continue;

                if(board[x2][y2] == 0) {
                    board[x2][y2] = board[x1][y1] + 1;
                    queue.offer(new int[]{x2, y2});
                    time = Math.max(time, board[x2][y2]);
                    ++sc;
                }
            }
        }

        return spaceCnt == sc ? time - 1 : Integer.MAX_VALUE;
    }
}
