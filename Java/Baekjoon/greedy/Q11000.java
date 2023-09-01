package Baekjoon.greedy;

import java.io.*;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/11000 (강의실 배정)
 * @classfication: greedy
 * @문제 푼 날짜 (자력으로 풂?): 23.09.01 (X)
 **/
public class Q11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> classRooms = new ArrayList<>();

        for(int i=0;i<N;i++) {
            int[] classRoom = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            classRooms.add(classRoom);
        }

        br.close();

        Collections.sort(classRooms, (c1, c2) -> {
            if(c1[0] == c2[0]) {
                return c1[1] - c2[1];
            } else {
                return c1[0] - c2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(classRooms.get(0)[1]);

        for(int i=1;i<classRooms.size();i++) {
            int end = pq.peek();
            int[] classRoom = classRooms.get(i);
            int str = classRoom[0];

            if(end <= str) {
                pq.poll();
            }

            pq.offer(classRoom[1]);
        }

        System.out.print(pq.size());
    }
}
