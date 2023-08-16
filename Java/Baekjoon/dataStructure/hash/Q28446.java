package Baekjoon.dataStructure.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/28446 (볼링공 찾아주기)
 * @classfication: hashmap, implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.12 (O)
 **/
public class Q28446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> bowlingBalls = new HashMap<>();
        StringBuilder result = new StringBuilder();

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());

            if(cmd == 1) {
                int num = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                bowlingBalls.put(weight, num);
            } else if(cmd == 2) {
                int weight = Integer.parseInt(st.nextToken());

                result.append(bowlingBalls.get(weight)).append('\n');
            }
        }

        br.close();

        System.out.println(result);
    }
}
