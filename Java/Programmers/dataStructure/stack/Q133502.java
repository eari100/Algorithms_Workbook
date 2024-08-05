package Programmers.dataStructure.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/133502 (햄버거 만들기)
 * @classification: stack
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.05 (X)
 **/
public class Q133502 {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<ArrayList<Integer>> stack = new Stack<>();

        for (int item : ingredient) {
            if (stack.isEmpty()) {
                if (item == 1) {
                    ArrayList<Integer> hamburger = new ArrayList<>();
                    hamburger.add(item);
                    stack.add(hamburger);
                }
            } else {
                ArrayList<Integer> pop = stack.pop();
                int size = pop.size();

                if (size == 3 && item == 1) {
                    ++answer;
                } else if (item == size + 1) {
                    pop.add(item);
                    stack.push(pop);
                } else {
                    if (item == 1) {
                        stack.push(pop);

                        ArrayList<Integer> hamburger = new ArrayList<>();
                        hamburger.add(item);
                        stack.add(hamburger);
                    } else {
                        stack = new Stack<>();
                    }
                }
            }
        }

        return answer;
    }
}
