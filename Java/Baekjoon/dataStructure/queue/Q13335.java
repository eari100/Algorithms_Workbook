package Baekjoon.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/13335 (트럭)
 *@classfication: queue
 * @문제 푼 날짜 (자력으로 풂?): 23.01.23 (x)
 **/
public class Q13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());;
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        int bridgeW = 0;
        int time = 0;


        st = new StringTokenizer(br.readLine());
        br.close();

        for(int i=0;i<n;i++)
            trucks.offer(Integer.parseInt(st.nextToken()));

        for(int i=0;i<w;i++)
            bridge.offer(0);

        while( !bridge.isEmpty() ) {
            ++time;
            bridgeW -= bridge.poll();

            if( !trucks.isEmpty() ) {
                int peek = trucks.peek();
                if(peek + bridgeW <= L) {
                    bridgeW += peek;
                    bridge.offer(trucks.poll());
                } else {
                    bridge.offer(0);
                }
            }
        }

        System.out.print(time);
    }
}
