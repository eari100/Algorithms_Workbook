package Baekjoon.greedy;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 *@source: https://www.acmicpc.net/problem/13904 (과제)
 *@classfication: greedy
 **/
public class Q13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> works = new ArrayList<>();

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            works.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        br.close();

        Collections.sort(works, (o1, o2) -> o2[1] - o1[1]);

        int[] memo = new int[1000+1];
        for(int[] arr : works) {
            for(int j=arr[0];j>0;j--) {
                if(memo[j] == 0) {
                    memo[j] = arr[1];
                    break;
                }
            }
        }

        System.out.print(IntStream.of(memo).sum());
    }
}
