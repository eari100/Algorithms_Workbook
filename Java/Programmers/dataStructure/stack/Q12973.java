package Programmers.dataStructure.stack;

import java.util.Stack;

/**
 *@source: https://programmers.co.kr/learn/courses/30/lessons/12973# (짝지어 제거하기)
 *@classfication: stack
 **/
public class Q12973 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(!stack.empty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
