package Baekjoon;

import java.io.*;
import java.util.*;

/**
 *@source: https://www.acmicpc.net/problem/10773
 *@classfication: stack
 **/
public class Q10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<K;i++) {
            int x = Integer.parseInt(br.readLine());

            if(x==0) stack.pop();
            else stack.push(x);
        }

        System.out.print(stack.stream().mapToInt(s -> s).sum());
        // System.out.print(stack.stream().reduce(0, Integer::sum));
    }
}
