package Baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/1015 (수열 정렬)
 * @classification: sort
 * @문제 푼 날짜 (자력솔?): 23.12.31 (O)
 **/
public class Q1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sequence = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        br.close();

        int[] sortedSequence = Arrays.copyOf(sequence, sequence.length);
        Arrays.sort(sortedSequence);

        StringBuilder result = new StringBuilder();

        for(int i=0;i<n;i++) {
            int num1 = sequence[i];
            for(int j=0;j<n;j++) {
                int num2 = sortedSequence[j];

                if(num1 == num2) {
                    sortedSequence[j] = -1;
                    result.append(j).append(' ');
                    break;
                }
            }
        }

        System.out.print(result);
    }
}
