package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *@source: https://www.acmicpc.net/problem/16953 (A → B)
 *@classfication: bfs
 *@reference: https://www.acmicpc.net/board/view/16953
 **/
public class Q16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        br.close();

        System.out.println(bfs(A, B));
    }

    private static long bfs(long A, long B) {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{A, 1L});

        long ans = -1;
        while( !queue.isEmpty() ) {
            long[] poll = queue.poll();

            if(poll[0] == B) {
                ans = poll[1];
                break;
            }

            long x1 = poll[0]*2;
            long x2 = (poll[0] * 10) + 1;

            if(x1 <= B) queue.offer(new long[]{x1, poll[1] + 1});
            if(x2 <= B) queue.offer(new long[]{x2, poll[1] + 1});
        }

        return ans;
    }
}
