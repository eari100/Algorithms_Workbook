package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/8980 (택배)
 * @classification: greedy
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.11 (O)
 **/
public class Q8980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), limitWeight = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int score = 0;
        int[] truck = new int[n+1];

        ArrayList<int[]>[] orders = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            orders[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken()), count = Integer.parseInt(st.nextToken());

            orders[start].add(new int[]{end, count});
        }

        br.close();

        for(int i=1;i<=n;i++) {
            score += truck[i];
            truck[i] = 0;

            ArrayList<int[]> order = orders[i];

            for(int j=0;j<order.size();j++) {
                int[] item = order.get(j);
                int end = item[0], count = item[1];

                truck[end] += count;
            }

            int weight = 0;
            int[] tempTruck = new int[n+1];
            for(int j=1;j<=n;j++) {
                int weightOne = truck[j];

                int sumWeight = weight + weightOne;

                if(sumWeight <= limitWeight) {
                    tempTruck[j] = truck[j];
                    weight = sumWeight;
                } else {
                    tempTruck[j] = limitWeight - weight;
                    break;
                }
            }

            truck = Arrays.copyOf(tempTruck, tempTruck.length);
        }

        System.out.print(score);
    }
}
