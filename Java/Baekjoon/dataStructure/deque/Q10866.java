package Baekjoon.dataStructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @source: https://www.acmicpc.net/problem/10866 (덱)
 * @classfication: deque
 * @문제 푼 날짜 (자력으로 풂?): 23.04.23 (O)
 **/
// todo: 자료구조를 사용하지말고 직접 구현해보자
public class Q10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        while(N-- > 0) {
            String command = br.readLine();

            if(command.startsWith("push_front")) {
                String[] commandArr = command.split(" ");
                deque.addFirst(Integer.valueOf(commandArr[1]));
            } else if(command.startsWith("push_back")) {
                String[] commandArr = command.split(" ");
                deque.addLast(Integer.valueOf(commandArr[1]));
            } else if(command.equals("pop_front")) {
                result.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
            } else if(command.equals("pop_back")) {
                result.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n');
            } else if(command.equals("size")) {
                result.append(deque.size()).append('\n');
            } else if(command.equals("empty")) {
                result.append(deque.isEmpty() ? 1 : 0).append('\n');
            } else if(command.equals("front")) {
                result.append(deque.isEmpty() ? -1 : deque.getFirst()).append('\n');
            } else if(command.equals("back")) {
                result.append(deque.isEmpty() ? -1 : deque.getLast()).append('\n');
            }
        }
        br.close();

        System.out.print(result);
    }
}
