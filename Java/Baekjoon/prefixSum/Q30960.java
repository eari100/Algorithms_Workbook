package Baekjoon.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/30960 (조별 과제)
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?): 23.12.19 (X, ps 향유회에서 풀이 받음)
 **/
public class Q30960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] persons = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            int person = Integer.parseInt(st.nextToken());;
            persons[i] = person;
        }

        br.close();

        Arrays.sort(persons);

        long result = 0;
        int y1 = 0;
        int y2 = persons[2] - persons[0];
        int y3 = 0;
        result += y2;

        for(int i=3;i<n;i+=2) {
            int minus = persons[i+1] - persons[i];
            if(n>3 && i == 3) {
                y3 = minus;
            }
            result += minus;
        }

        long prevY = result;

        for(int i=6;i<n;i+=2) {
            long currY = prevY - y2 - y3;
            int s1 = i-6;
            int e1 = s1+1;
            int s2 = e1+1;
            int e2 = s2+2;
            int s3 = e2+1;
            int e3 = s3+1;

            y1 = persons[e1] - persons[s1];
            y2 = persons[e2] - persons[s2];
            y3 = persons[e3] - persons[s3];

            currY += (y1 + y2);

            result = Math.min(result, currY);
            prevY = currY;
        }

        if(n > 5) {
            prevY -= (y2 + y3);

            int e2 = persons.length-1;
            int s2 = e2 - 2;
            int e1 = s2 - 1;
            int s1 = e1 - 1;

            prevY += (persons[e2] - persons[s2]) + (persons[e1] - persons[s1]);

            result = Math.min(result, prevY);
        }

        System.out.println(result);
    }
}
