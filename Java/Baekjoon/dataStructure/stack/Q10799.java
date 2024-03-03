package Baekjoon.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @source: https://www.acmicpc.net/problem/10799 (쇠막대기)
 * @classification: stack
 * @문제 푼 날짜 (자력으로 풂?): 23.03.03 (O)
 **/
public class Q10799 {
    public static void main(String[] args) throws IOException {
        int ironBarCnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String env = br.readLine();
        br.close();

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<env.length();i++) {
            char curr = env.charAt(i);

            if(stack.isEmpty()) {
                stack.push(curr);
            } else {
                if(curr == '(') {
                    stack.push(curr);
                } else {
                    char peek = stack.peek();

                    if(peek == '(') {
                        stack.pop();
                        char prev = env.charAt(i-1);

                        if(prev == '(')
                            ironBarCnt += stack.size();
                        else
                            ++ironBarCnt;
                    }
                }
            }
        }

        System.out.print(ironBarCnt);
    }
}
