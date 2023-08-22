package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/14911 (궁합 쌍 찾기)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.22 (O)
 **/
// todo: hash, tree map 을 이용하는 방법으로 풀어볼 것
public class Q14911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int target = Integer.parseInt(br.readLine());

        br.close();

        Arrays.sort(nums);
        LinkedHashSet<String> result = new LinkedHashSet<>();

        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j<nums.length;j++) {
                int sum = nums[i] + nums[j];
                if(sum == target) {
                    StringBuilder str = new StringBuilder();
                    str.append(nums[i]).append(' ').append(nums[j]).append('\n');
                    result.add(str.toString());
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        for(String str : result) {
            answer.append(str);
        }

        answer.append(result.size());

        System.out.print(answer);
    }
}
