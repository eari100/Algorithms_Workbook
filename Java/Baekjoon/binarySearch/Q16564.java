package Baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/16564 (히오스 프로게이머)
 * @classfication: binary search
 * @upsolving: true
 * @문제 푼 날짜 (자력으로 풂?): 23.07.09 (X, https://yanoo.tistory.com/94)
 **/
public class Q16564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//캐릭터들 개수
        int K = Integer.parseInt(st.nextToken());//올릴 수 있는 레벨 총합
        int[] levels = new int[N];//캐릭터별 레벨
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(levels);

        int result = 0;
        int left = levels[0];
        int right = levels[N-1];
        while(left<=right) {
            int mid = (left+right)/2;
            System.out.println(mid);
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if(levels[i]<mid) sum += (mid-levels[i]);
            }
            if(sum<=K) {
                result = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        System.out.println(result);
    }
}
