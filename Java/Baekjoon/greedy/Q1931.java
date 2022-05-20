package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1931
 * @classfication: greedy, Activity Selection problem
 * @reference: https://st-lab.tistory.com/145
 **/
public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new int[]{str, end});
        }
        br.close();

        final int[] cnt = {0};
        final int[] prevEnd = {0};

        list.stream().sorted((l1, l2) -> {
            int result = l1[1] - l2[1];
            if(result == 0) return l1[0] - l2[0];
            return result;
        }).forEach(l -> {
            if(prevEnd[0] <= l[0]) {
                prevEnd[0] = l[1];
                ++cnt[0];
            }
        });

        System.out.print(cnt[0]);
    }
}
