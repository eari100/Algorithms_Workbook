package Baekjoon.dataStructure.treeMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @source: https://www.acmicpc.net/problem/28445 (알록달록 앵무새)
 * @classfication: treemap, implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.12 (O)
 **/
public class Q28445 {
    public static void main(String[] args) throws IOException {
        TreeSet<String> colors = new TreeSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<2;i++)
            colors.add(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<2;i++)
            colors.add(st.nextToken());

        br.close();

        StringBuilder result = new StringBuilder();

        for(String body : colors) {
            for(String tale : colors) {
                result.append(body).append(' ').append(tale).append('\n');
            }
        }

        System.out.println(result);
    }
}
