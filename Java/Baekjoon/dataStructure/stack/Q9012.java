package Baekjoon.dataStructure.stack;

import java.io.*;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i=Integer.parseInt(br.readLine());i>0;i--)
            sb.append(process(br.readLine())).append("\n");
        br.close();

        System.out.print(sb);
    }

    private static String process(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(') stack.push(c);
            else if(stack.isEmpty()) return "NO";
            else stack.pop();
        }

        if(stack.isEmpty()) return "YES";
        else return "NO";
    }
}
