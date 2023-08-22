package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/2075 (N번째 큰 수)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.22 (O)
 **/
// todo: 메모리 계산 잘못한 풀이 나중에 priority queue로 풀어볼 것
public class Q2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[arithmeticSequence(1, 1, N)];
        int numsIdx = 0;
        int[] temp;

        for(int i=0;i<N;i++) {
            int tempIdx = 0;
            temp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Arrays.sort(temp);

            for(int j=1;j<=i+1;j++) {
                nums[numsIdx++] = temp[N - ++tempIdx];
            }
        }

        br.close();

        Arrays.sort(nums);

        System.out.print(nums[nums.length - N]);
    }

    private static int arithmeticSequence(int a1, int d, int N) {
        return N * (2 * a1 + (N-1) * d) / 2;
    }
}