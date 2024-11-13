package Baekjoon.backtracking.Q15666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/15666 (N과 M (12))
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 24.11.14 (O)
 **/
public class D241113 {
    static List<Integer> arr;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        boolean[] checked = new boolean[10000+1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(st.nextToken());

            if(!checked[num]) {
                checked[num] = true;
                arr.add(num);
            }
        }

        br.close();

        Collections.sort(arr);

        bt(0, 0, new int[m]);

        System.out.print(result);
    }

    private static void bt(int ai, int ni, int[] nums) {
        if(ni == nums.length) {
            for(int num : nums) {
                result.append(num).append(' ');
            }

            result.append('\n');

            return;
        }

        for(int i=ai;i<arr.size();i++) {
            nums[ni] = arr.get(i);
            bt(i, ni+1, nums);
        }
    }
}
