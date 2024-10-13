package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/8922 (두찌 수열)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.10.13 (X, int overflow)
 **/
public class Q8922 {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer data = new StringTokenizer(br.readLine());
            int[] nums = new int[len];
            StringBuilder sum = new StringBuilder();
            HashSet<String> set = new HashSet<>();

            for(int i=0;i<len;i++) {
                nums[i] = Integer.parseInt(data.nextToken());
                sum.append(nums[i]);
            }

            set.add(sum.toString());

            while(nextArr(nums, set)) {}
        }

        br.close();

        System.out.print(answer);
    }

    private static boolean nextArr(int[] arr, HashSet<String> set) {
        int prevLen = set.size();
        StringBuilder sum = new StringBuilder();
        int firstNum = arr[0];

        for(int i=0;i<arr.length-1;i++) {
            arr[i] = Math.abs(arr[i+1] - arr[i]);
            sum.append(arr[i]);
        }

        arr[arr.length-1] = Math.abs(arr[arr.length-1] - firstNum);
        sum.append(arr[arr.length - 1]);

        boolean isZero = true;

        for(int num : arr) {
            if(num != 0) {
                isZero = false;
                break;
            }
        }

        if(isZero) {
            answer.append("ZERO").append('\n');

            return false;
        }

        set.add(sum.toString());

        if(prevLen == set.size()) {
            answer.append("LOOP").append('\n');

            return false;
        }

        return true;
    }
}
