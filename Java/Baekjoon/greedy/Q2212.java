package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


/**
 * @source: https://www.acmicpc.net/problem/2212 (센서)
 * @classfication: Greedy
 * @문제 푼 날짜 (자력으로 풂?): 23.08.19 (X, 비슷한 유형을 푼 적이 있었는데 업솔빙 실패)
 **/
public class Q2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] nArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        br.close();

        Arrays.sort(nArr);

        Integer[] diff = new Integer[nArr.length - 1];

        for(int i=1;i<nArr.length;i++) {
            diff[i-1] = nArr[i] - nArr[i-1];
        }

        Arrays.sort(diff, Collections.reverseOrder());

        int result = 0;

        for(int i=K-1;i<diff.length;i++) {
            result += diff[i];
        }

        System.out.print(result);
    }
}
