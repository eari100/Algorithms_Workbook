package Baekjoon.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/17298 (오큰수)
 * @classfication: stack
 * @문제 푼 날짜 (자력으로 풂?): 24.12.07 (태그 알고 있는 상태에서 문제풂)
 **/
public class Q17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nge = new int[n];
        Stack<int[]> stk = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        stk.add(new int[]{Integer.valueOf(st.nextToken()), 0});
        StringBuilder result = new StringBuilder();

        for(int i=1;i<n;i++) {
            int num = Integer.parseInt(st.nextToken());

            while(!stk.isEmpty()) {
                int[] peek = stk.peek();
                int num2 = peek[0], index = peek[1];

                if(num > num2) {
                    nge[index] = num;
                    stk.pop();
                } else {
                    break;
                }
            }

            stk.add(new int[]{num, i});
        }

        br.close();

        for(int i : nge) {
            result.append(i == 0 ? -1 : i).append(' ');
        }

        System.out.print(result);
    }
}
