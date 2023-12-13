package Baekjoon.math.combinatorics;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/9375 (패션왕 신해빈)
 * @classfication: combinatorics
 * @문제 푼 날짜 (자력으로 풂?): 23.12.10 (O, well known)
 **/
public class Q9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            int clothesCnt = Integer.parseInt(br.readLine());
            HashMap<String, Integer> clothes = new HashMap<>();
            int numberOfCases = 1;

            for(int j=0;j<clothesCnt;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }

            for(Map.Entry<String, Integer> entry : clothes.entrySet()) {
                numberOfCases *= (entry.getValue() + 1);
            }

            --numberOfCases;
            bw.write(String.valueOf(numberOfCases));
            bw.write('\n');
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
