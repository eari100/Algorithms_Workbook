package Baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/3273 (두 수의 합)
 * @classfication: two-pointer
 * @문제 푼 날짜 (자력으로 풂?): 23.08.06 (O)
 **/
public class Q3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(nums);

        int target = Integer.parseInt(br.readLine());

        br.close();

        int str = 0;
        int end = n - 1;

        while(str < end) {
            int sum = nums[str] + nums[end];

            if(sum == target) {
                ++answer;
                ++str;
                --end;
            } else if(sum < target) {
                ++str;
            } else if(sum > target) {
                --end;
            }
        }

        System.out.print(answer);
    }
}
