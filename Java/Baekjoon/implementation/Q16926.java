package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/16926 (배열 돌리기 1)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.07.22 (O)
 **/
// todo: 더 효율적인 풀이 존재. 업솔빙 때 구상해볼 것
public class Q16926 {
    final static int[] nX = {1, 0, -1, 0};
    final static int[] nY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] array = new int[N+2][M+2];
        boolean[][] visited = new boolean[N+2][M+2];

        for(int i=0;i<N+2;i++) {
            for(int j=0;j<M+2;j++) {
                visited[i][j] = true;
            }
        }

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }

        br.close();

        for(int i=0;i<R;i++) {
            int x1 = 1, y1 = 1;
            boolean[][] copyVisited = Arrays.stream(visited)
                    .map(boolean[]::clone)
                    .toArray(boolean[][]::new);

            int nXIdx = 0, nYIdx = 0;
            int tmp1 = array[x1][y1];

            while(true) {
                int x2 = x1 + nX[nXIdx];
                int y2 = y1 + nY[nYIdx];

                if(copyVisited[x2][y2]) {
                    if(nXIdx == 3) {
                        int x3 = x2 + 1;
                        int y3 = x2 + 1;
                        if(copyVisited[x3][y3]) break;

                        nXIdx = 0;
                        nYIdx = 0;
                        x1 = x3;
                        y1 = y3;
                        tmp1 = array[x1][y1];
                        continue;
                    }

                    ++nXIdx;
                    ++nYIdx;
                    continue;
                }

                int tmp2 = array[x2][y2];
                array[x2][y2] = tmp1;
                tmp1 = tmp2;
                x1 = x2;
                y1 = y2;
                copyVisited[x2][y2] = true;
            }
        }

        StringBuilder result = new StringBuilder();

        for(int i=1;i<N+1;i++) {
            for(int j=1;j<M+1;j++) {
                result.append(array[i][j]).append(' ');
            }
            result.append('\n');
        }

        System.out.print(result);
    }
}
