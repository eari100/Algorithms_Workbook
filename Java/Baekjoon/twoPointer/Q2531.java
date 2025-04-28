package Baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2531 (회전 초밥)
 * @classification: two pointer
 * @문제 푼 날짜 (자력으로 풂?): 25.04.28 (O)
 **/
public class Q2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int total =  Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        int bonus = Integer.parseInt(st.nextToken());
        int[] arr = new int[cnt];
        int max_count;
        int count = 0;
        int[] nums = new int[total+1];

        for(int i=0;i<cnt;i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if(i < len) {
                if(nums[arr[i]] == 0) {
                    ++count;
                }

                nums[arr[i]]++;
            }
        }

        max_count = count;

        if(nums[bonus] == 0) {
            max_count++;
        }

        br.close();

        for(int i=1;i<cnt;i++) {
            int prev = i - 1;
            int next = (i + len-1) % cnt;
            if(--nums[arr[prev]] == 0) count--;
            if(len < cnt && ++nums[arr[next]] == 1) count++;

            if(nums[bonus] == 0) {
                max_count = Math.max(max_count, count+1);
            } else {
                max_count = Math.max(max_count, count);
            }
        }

        System.out.println(max_count);
    }
}
