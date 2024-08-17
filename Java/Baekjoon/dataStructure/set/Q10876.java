package Baekjoon.dataStructure.set;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/10867 (중복 빼고 정렬하기)
 * @classification: set, sort
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.17 (O)
 **/
public class Q10876 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer data = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        while(N-- > 0) {
            int num = Integer.parseInt(data.nextToken());
            set.add(num);
        }

        br.close();

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        StringBuilder result = new StringBuilder();

        for(int num : list) {
            result.append(num).append(' ');
        }

        System.out.print(result);
    }
}
