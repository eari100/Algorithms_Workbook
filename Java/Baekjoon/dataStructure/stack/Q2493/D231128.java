package Baekjoon.dataStructure.stack.Q2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2493 (탑)
 * @classfication: stack
 * @문제 푼 날짜 (자력으로 풂?): 23.11.28 (X, 물체 구상 시 변형하는 사고를 가질 것)
 **/
public class D231128 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stk = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i=1;i<=N;i++) {
            int curr = Integer.parseInt(st.nextToken());

            while( !stk.empty() ) {
                int[] peek = stk.peek();
                int prev = peek[1];

                if(prev > curr) {
                    result.append(peek[0]).append(' ');
                    stk.add(new int[]{i, curr});
                    break;
                } else {
                    stk.pop();
                }
            }

            if(stk.isEmpty()) {
                result.append(0).append(' ');
                stk.add(new int[]{i, curr});
            }
        }

        System.out.print(result);
    }
}
