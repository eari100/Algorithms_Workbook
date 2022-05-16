package Baekjoon.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/11866 (요세푸스 문제 0)
 *@classfication: queue
 **/
public class Q11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");

        int cnt = 0;
        while( !queue.isEmpty() ) {
            int poll = queue.poll();
            ++cnt;

            if(cnt < K) queue.offer(poll);
            else {
                sb.append(poll).append(", ");
                cnt = 0;
            }
        }

        sb.setLength(sb.length() - 2);
        sb.append('>');

        System.out.print(sb);
    }
}
