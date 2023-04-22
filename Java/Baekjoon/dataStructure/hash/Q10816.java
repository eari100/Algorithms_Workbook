package Baekjoon.dataStructure.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/10816 (숫자 카드 2)
 * @classfication: hash
 * @문제 푼 날짜 (자력으로 풂?): 23.04.22 (O)
 **/
// 이분 탐색으로도 풀어볼 것
public class Q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        StringTokenizer nums1 = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(nums1.nextToken());

            if(hashMap.containsKey(num))
                hashMap.put(num, hashMap.get(num)+1);
            else
                hashMap.put(num, 1);
        }


        int M = Integer.parseInt(br.readLine());

        StringTokenizer nums2 = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++) {
            int num = Integer.parseInt(nums2.nextToken());
            int value = hashMap.containsKey(num) ? hashMap.get(num) : 0;

            result.append(value).append(' ');
        }

        br.close();

        System.out.print(result);
    }
}
