package Atcoder.AtCoder_Beginner_contest_317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://atcoder.jp/contests/abc317/tasks/abc317_b (B - MissingNo.)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.26 (O)
 **/
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        Arrays.sort(nums);

        int answer = 0;

        for(int i=1;i<N;i++) {
            if(nums[i-1] + 1 != nums[i]) {
                answer = nums[i-1] + 1;
                break;
            }
        }

        if(answer == 0) {
            if(nums[0] - 1 >= 1) {
                answer = nums[0] - 1;
            } else if(nums[nums.length - 1] + 1 <= 1000) {
                answer = nums[nums.length - 1] + 1;
            }
        }

        System.out.print(answer);
    }
}
