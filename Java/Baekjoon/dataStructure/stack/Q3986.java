package Baekjoon.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @source: https://www.acmicpc.net/problem/3986 (좋은 단어)
 * @classification: stack
 **/
public class Q3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int goodWordCnt = 0;

        while(N-- > 0) {
            String word = br.readLine();
            Stack<Character> stack = new Stack<>();

            for(char c : word.toCharArray()) {
                if(stack.size() == 0) {
                    stack.push(c);
                    continue;
                }

                char peek = stack.peek();

                if(peek == c) stack.pop();
                else stack.push(c);
            }

            if(stack.size() == 0) ++goodWordCnt;
        }
        br.close();
        System.out.print(goodWordCnt);
    }
}
