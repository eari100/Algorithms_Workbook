package Atcoder.AtCoder_Beginner_contest_317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://atcoder.jp/contests/abc317/tasks/abc317_a (A - Potions)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.26 (O)
 **/
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int potionCnt = Integer.parseInt(st.nextToken());
        int curr = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] potions = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        br.close();

        int i = 1;
        for(int potion : potions) {
            if(curr + potion >= target) {
                System.out.print(i);
                break;
            }
            ++i;
        }
    }
}
