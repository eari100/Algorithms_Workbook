package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2591 (숫자카드)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.04.22 (O, 0이라는 카드는 존재하지 못한다는 케이스를 잘 생각하지 못함)
 **/
public class Q2591 {
    static int combinations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = br.readLine().chars().map(Character::getNumericValue).toArray();
        br.close();

        backtracking(nums, 0);
        System.out.print(combinations);
    }

    private static void backtracking(int[] nums, int index) {
        int indexGap = nums.length - 1 - index;

        if(indexGap > -1) {
            if(nums[index] == 0) return;

            if(indexGap == 0) {
                ++combinations;
                return;
            }
            backtracking(nums, index+1);
        }

        if(indexGap > 0) {
            int num = nums[index] * 10 + nums[index+1];
            if(num < 35) {
                if(indexGap == 1) {
                    ++combinations;
                    return;
                }
                backtracking(nums, index+2);
            }
        }
    }
}
