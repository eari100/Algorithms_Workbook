package Baekjoon.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @source: https://www.acmicpc.net/problem/1935 (후위 표기식2)
 * @classfication: stack
 * @문제 푼 날짜 (자력으로 풂?): 23.01.21 (X)
 **/
public class Q1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        String postFix = br.readLine();
        double[] valueDb = new double[N];

        for(int i=0;i<valueDb.length;i++)
            valueDb[i] = Double.parseDouble(br.readLine());


        br.close();

        for(char c : postFix.toCharArray()) {
            if(c == '+') {
                double y = stack.pop();
                double x = stack.pop();

                stack.push(x+y);
            } else if(c == '-') {
                double y = stack.pop();
                double x = stack.pop();

                stack.push(x-y);
            } else if(c == '*') {
                double y = stack.pop();
                double x = stack.pop();

                stack.push(x*y);
            } else if(c == '/') {
                double y = stack.pop();
                double x = stack.pop();

                stack.push(x/y);
            } else {
                stack.push(valueDb[c - 'A']);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
