package Baekjoon.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @source: https://www.acmicpc.net/problem/6198 (옥상 정원 꾸미기)
 * @classification: monotone stack
 * @문제 푼 날짜 (자력솔?): 24.01.03 (X)
 **/
public class Q6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long result = 0;

        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());

            while( !stack.isEmpty() && stack.peek() <= num ) {
                stack.pop();
            }

            stack.add(num);

            result += stack.size() - 1;
        }

        br.close();

        System.out.print(result);
    }
}
