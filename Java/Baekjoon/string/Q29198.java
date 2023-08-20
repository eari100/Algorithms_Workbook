package Baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/29198 (이번에는 C번이 문자열)
 * @classfication: string
 * @문제 푼 날짜 (자력으로 풂?): 23.08.18 (O)
 * @reference: https://solved.ac/arena/4/editorial
 **/
// todo: priority queue 를 이용하는 더 좋은 풀이가 존재
public class Q29198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];

        for(int i=0;i<N;i++) {
            char[] cArr =  br.readLine().toCharArray();
            Arrays.sort(cArr);
            arr[i] = new String(cArr);
        }

        br.close();

        Arrays.sort(arr);

        int[] chArr = new int[26];

        for(int i=0;i<K;i++) {
            String str = arr[i];

            for(char c : str.toCharArray()) {
                ++chArr[c - 'A'];
            }
        }

        StringBuilder result = new StringBuilder();

        for(int i=0;i<chArr.length;i++) {
            if(chArr[i] > 0) {
                char c = (char) (i + (int)'A');

                for(int j=0;j<chArr[i];j++)
                    result.append(c);
            }
        }

        System.out.print(result);
    }
}
