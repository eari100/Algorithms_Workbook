package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/19941 (햄버거 분배)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 23.12.25 (O)
 **/
public class Q19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int obj_cnt = Integer.parseInt(st.nextToken()), range = Integer.parseInt(st.nextToken());
        char[] objs = br.readLine().toCharArray();
        int eat_cnt = 0;
        int bugger_index = 0;

        for(int i=0;i<obj_cnt;i++) {
            char obj1 = objs[i];

            if(obj1 == 'P') {
                for(int j=Math.max(bugger_index, i-range);j<=Math.min(i+range, obj_cnt-1);j++) {
                    char obj2 = objs[j];

                    if(obj2 == 'H') {
                        ++eat_cnt;
                        bugger_index = j;
                        objs[j] = 'E';
                        break;
                    }
                }
            }
        }

        br.close();

        System.out.println(eat_cnt);
    }
}
