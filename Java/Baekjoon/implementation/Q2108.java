package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/2108 (통계학)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.10.02 (X, chatgpt로 key 오름차순, value 내림차순 정렬하는 법 물어봄)
 **/
public class Q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int max = -4000;
        int min = 4000;
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<N;i++) {
            int x = Integer.parseInt(br.readLine());

            max = Math.max(max, x);
            min = Math.min(min, x);
            nums[i] = x;
            sum += x;

            int hashKey = x;
            if(hashMap.containsKey(hashKey))
                hashMap.put(hashKey, hashMap.get(hashKey)+1);
            else
                hashMap.put(hashKey, 1);
        }

        br.close();

        float average_f = (float) sum / N;
        int average_i =  Math.round(average_f);

        Arrays.sort(nums);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, (h1, h2) -> h1.getValue() == h2.getValue() ? h1.getKey() - h2.getKey() : h2.getValue() - h1.getValue());

        Map.Entry<Integer, Integer> l1 = list.get(0);
        int mode = 0;
        if(list.size() == 1) {
            mode = l1.getKey();
        } else {
            Map.Entry<Integer, Integer> l2 = list.get(1);
            mode = l1.getValue() == l2.getValue() ? l2.getKey() : l1.getKey();
        }

        result.append(average_i).append('\n')
                .append(nums[nums.length/2]).append('\n')
                .append(mode).append('\n')
                .append(max-min);

       System.out.print(result);
    }
}
