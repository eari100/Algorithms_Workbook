package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1759 (암호 만들기)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.04.01 (O)
 **/
public class Q1759 {
    static String[] alphabets;
    static boolean[] visited;
    static StringBuilder resultList = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        alphabets = new String[C];
        visited = new boolean[C];

        alphabets = br.readLine().split(" ");

        Arrays.sort(alphabets);

        br.close();
        backtracking(0, new String[L], L, 0);

        System.out.print(resultList);
    }

    private static void backtracking(int depth, String[] result, int maxDepth, int strIdx) {
        if(depth == maxDepth) {
            StringBuilder sb = new StringBuilder();
            int 모음갯수 = 0;
            for(int i=0;i<result.length;i++) {
                if(result[i].equals("a") || result[i].equals("e") || result[i].equals("i")
                        || result[i].equals("o") || result[i].equals("u")) {
                    ++모음갯수;
                }

                sb.append(result[i]);
            }

            if(모음갯수 > 0 && result.length - 모음갯수 > 1) {
                resultList.append(sb);
                resultList.append('\n');
            }

            return;
        }

        for(int i=strIdx;i<alphabets.length;i++) {
            if(visited[i]) continue;

            visited[i] = true;
            result[depth] = alphabets[i];
            backtracking(depth+1, result, maxDepth, i+1);
            visited[i] = false;
        }
    }
}
