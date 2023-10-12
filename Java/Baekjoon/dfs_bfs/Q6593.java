package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/6593 (상범 빌딩)
 * @classification: bfs
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.10.12 (O)
 **/
public class Q6593 {
    static final int[] nL = {-1, 1, 0, 0, 0, 0};
    static final int[] nR = {0, 0, -1, 1, 0, 0};
    static final int[] nC = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();
        final String SUCCESS1 = "Escaped in ";
        final String SUCCESS2 = " minute(s).";
        final String TRAPPED = "Trapped!";

        while(true) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0)
                break;

            char[][][] building = new char[L][R][C];
            Queue<int[]> queue = new LinkedList<>();

            for(int i=0;i<L;i++) {
                for(int j=0;j<R;j++) {
                    String row = br.readLine();
                    for(int k=0;k<C;k++) {
                        char obj = row.charAt(k);

                        if(obj == 'S') {
                            queue.offer(new int[]{i, j, k, 0});
                        }

                        building[i][j][k] = obj;
                    }
                }
                br.readLine();
            }

            int time = escapeTime(building, queue);

            if(time == -1)
                result.append(TRAPPED);
            else
                result.append(SUCCESS1).append(time).append(SUCCESS2);

            result.append('\n');
        }

        System.out.print(result);
        br.close();
    }

    private static int escapeTime(char[][][] building, Queue<int[]> queue) {

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int l1 = poll[0];
            int r1 = poll[1];
            int c1 = poll[2];
            int t1 = poll[3];

            for(int i=0;i<nL.length;i++) {
                int l2 = l1 + nL[i];
                int r2 = r1 + nR[i];
                int c2 = c1 + nC[i];
                int t2 = t1 + 1;

                if(l2 < 0 || l2 >= building.length)
                    continue;
                if(r2 < 0 || r2 >= building[0].length)
                    continue;
                if(c2 < 0 || c2 >= building[0][0].length)
                    continue;

                if(building[l2][r2][c2] == 'E')
                    return t2;

                if(building[l2][r2][c2] != '.')
                    continue;

                building[l2][r2][c2] = 'x';
                queue.offer(new int[]{l2, r2, c2, t2});
            }
        }

        return -1;
    }
}
