package Baekjoon.adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @source: https://www.acmicpc.net/problem/30884 (Yeah, but How?)
 * @classification: adhoc
 * @문제 푼 날짜 (자력으로 풂?): 23.12.27 (O)
 **/
public class Q30884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        for(char _new : br.readLine().toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(_new);
            } else {
                char peek = stack.peek();

                if(peek == '(' && _new == ')') {
                    stack.push('1');
                    stack.push(')');
                } else if(peek == ')' && _new == '(') {
                    stack.push('+');
                    stack.push('(');
                } else {
                    stack.push(_new);
                }
            }
        }

        br.close();

        StringBuilder result = new StringBuilder();

        stack.forEach(result::append);

        System.out.print(result);
    }
}
