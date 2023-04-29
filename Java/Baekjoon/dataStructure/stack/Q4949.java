package Baekjoon.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @source: https://www.acmicpc.net/problem/4949 (균형잡힌 세상)
 * @classfication: stack
 * @문제 푼 날짜 (자력으로 풂?): 23.04.29 (O, 입출력 형식이 최악인 문제)
 **/
public class Q4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder result = new StringBuilder();
        Stack<Character> stack;

        while(true) {
            stack = new Stack<>();
            str = br.readLine();
            if(str.equals(".")) break;

            for(char c : str.toCharArray()) {
                if( !stack.empty() ) {
                    char peek = stack.peek();

                    if(peek =='[' && c == ']') {
                        stack.pop();
                    }

                    else if(peek =='(' && c == ')') {
                        stack.pop();
                    }

                    else if(c == '[' || c == ']' || c == '(' || c == ')') {
                        stack.add(c);
                    }
                }

                else if(c == '[' || c == ']' || c == '(' || c == ')') {
                    stack.add(c);
                }
            }

            result.append(stack.size() == 0 ? "yes" : "no").append('\n');
        }

        br.close();

        System.out.print(result);
    }
}
