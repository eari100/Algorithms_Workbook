package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/29791 (에르다 노바와 오리진 스킬)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.09.08 (O)
 **/
public class Q29791 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nArr = toArray(br.readLine());
        int[] mArr = toArray(br.readLine());

        Arrays.sort(nArr);
        Arrays.sort(mArr);

        br.close();

        int result1 = countCc(nArr, 100);
        int result2 = countCc(mArr, 360);

        StringBuilder result = new StringBuilder();
        result.append(result1).append(' ').append(result2);

        System.out.print(result);
    }

    private static int[] toArray(String str) {
        return Arrays.stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int countCc(int[] arr, int coolTime) {
        int time = 0;
        int cc = 0;

        for(int i=0;i<arr.length;i++) {
            int n = arr[i];

            if(time < n) {
                ++cc;
                time = n + coolTime;
            }
        }

        return cc;
    }
}
