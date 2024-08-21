package Programmers.dataStructure.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/154539 (뒤에 있는 큰 수 찾기)
 * @classification: stack
 * @문제 푼 날짜 (자력으로 풂?): 24.08.21 (O)
 **/
public class Q154539 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{0, numbers[0]});

        for(int i=1;i<numbers.length;i++) {
            int num = numbers[i];

            while( !stack.isEmpty() ) {
                int[] peek = stack.peek();

                if(peek[1] < num) {
                    stack.pop();
                    answer[peek[0]] = num;
                } else {
                    break;
                }
            }

            stack.add(new int[]{i, num});
        }

        return answer;
    }
}
