package Baekjoon.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @source: https://www.acmicpc.net/problem/1874 (스택 수열)
 * @classfication: stack, implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.10.02 (O)
 **/
public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        final String NO = "NO";
        int str = 1;

        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());

            while(str <= num) {
                if(N < str) {
                    System.out.print(NO);
                    System.exit(0);
                }
                stack.push(str++);
                result.append('+').append('\n');
            }

            if(stack.empty()) {
                System.out.print(NO);
                System.exit(0);
            } else {
                int peek = stack.peek();

                if(peek == num) {
                    stack.pop();
                    result.append('-').append('\n');
                } else {
                    System.out.print(NO);
                    System.exit(0);
                }
            }
        }

        br.close();

        System.out.print(result);
    }
}
