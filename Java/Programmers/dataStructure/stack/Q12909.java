package Programmers.dataStructure.stack;

import java.util.Stack;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12909 (올바른 괄호)
 * @classfication: stack
 * @문제 푼 날짜 (자력으로 풂?): 23.09.07 (O)
 **/
public class Q12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.add(c);
                continue;
            }

            Character peek = stack.peek();

            if(peek == '(' && c == ')')
                stack.pop();
            else
                stack.add(c);
        }

        return stack.size() == 0;
    }
}
