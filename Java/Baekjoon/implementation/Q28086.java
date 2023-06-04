package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/28086 (미소녀 컴퓨터 파루빗토 쨩)
 * @classfication: implementation, math
 * @문제 푼 날짜 (자력으로 풂?): 23.06.05 (O)
 **/
public class Q28086 {
    static char operator;
    static String operand1, operand2;
    static long result;
    static String octalResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String prompt = br.readLine();
        br.close();

        getOperands(prompt);

        long decimalOperand1 = Long.parseLong(operand1, 8);
        long decimalOperand2 = Long.parseLong(operand2, 8);

        calculate(decimalOperand1, decimalOperand2, operator);

        octalResult = result < 0 ? new StringBuilder().append('-').append(Long.toOctalString(result*-1)).toString() : Long.toOctalString(result);

        System.out.println(octalResult);
    }

    private static void getOperands(String prompt) {
        StringBuilder operand = new StringBuilder();
        int operandIndex = 0;

        for(int i=0;i<prompt.length();i++) {
            char c = prompt.charAt(i);

            if(i > 0 && operandIndex == 0 && (c == '+' || c == '-' || c == '*' || c == '/')) {
                operator = c;
                operand1 = operand.toString();
                ++operandIndex;
                operand = new StringBuilder();
            } else {
                operand.append(c);
            }
        }

        operand2 = operand.toString();
    }

    private static void calculate(long operand1, long operand2, char operator) {
        if(operator == '+') {
            result = operand1 + operand2;
        } else if(operator == '-') {
            result = operand1 - operand2;
        } else if(operator == '*') {
            result = operand1 * operand2;
        } else if(operator == '/') {
            if(operand2 == 0) {
                System.out.print("invalid");
                System.exit(0);
            } else {
                result = (long) Math.floor((double) operand1 / operand2);
            }
        }
    }
}
