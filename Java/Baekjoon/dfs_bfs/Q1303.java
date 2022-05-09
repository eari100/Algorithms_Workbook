package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/1303 (전쟁 - 전투)
 *@classfication: bfs
 **/
public class Q1303 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int wTotal = 0;
        int bTotal = 0;

        arr = new char[M][N];

        for(int i=0;i<M;i++) {
            String s = br.readLine();
            for(int j=0;j<N;j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        br.close();

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                if(arr[i][j] == 'W')
                    wTotal += Math.pow(bfs(i, j, 'W'), 2);
                else if(arr[i][j] == 'B')
                    bTotal += Math.pow(bfs(i, j, 'B'), 2);
            }
        }

        System.out.print(wTotal + " " + bTotal);
    }

    private static int bfs(int x, int y, char target) {
        Queue<int[]> queue = new LinkedList();

        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        queue.offer(new int[]{x, y});
        int result = 1; // 조건문을 통해 bfs()를 호출 했기 때문에 1부터 시작
        arr[x][y] = 'X';

        while(!queue.isEmpty()) {
            int[] xy = queue.poll();

            for(int i=0;i<4;i++) {
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];

                if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && arr[nx][ny] == target) {
                    queue.offer(new int[]{nx, ny});
                    arr[nx][ny] = 'X';
                    ++result;
                }
            }
        }

        return result;
    }
}

