package Baekjoon.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * @source: https://www.acmicpc.net/problem/12789 (도키도키 간식드리미)
 * @classification: stack
 * @문제 푼 날짜 (자력으로 풂?): 24.03.16 (O)
 **/
public class Q12789 {
    public static void main(String[] args) throws IOException {
        final String Nice = "Nice", Sad = "Sad";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        br.close();

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for(int i=nums.length-1;i>=0;i--) {
            stack1.push(nums[i]);
        }

        boolean pass = true;
        L1: for(int curr=1;curr<=n;curr++) {
            if(!stack1.isEmpty()) {
                int peek1 = stack1.peek();
                if(peek1 == curr) {
                    stack1.pop();
                    continue;
                }
            }

            if(!stack2.isEmpty()) {
                int peek2 = stack2.peek();
                if(peek2 == curr) {
                    stack2.pop();
                    continue;
                }
            }

            if(stack1.isEmpty()) {
                pass = false;
                break;
            }

            while( !stack1.isEmpty() ) {
                int pop1 = stack1.pop();

                if(pop1 == curr) {
                    break;
                }

                if(stack2.isEmpty()) {
                    stack2.push(pop1);
                } else {
                    int peek2 = stack2.peek();

                    if(peek2 < pop1) {
                        pass = false;
                        break L1;
                    } else {
                        stack2.push(pop1);
                    }
                }
            }
        }

        System.out.print(pass ? Nice : Sad);
    }
}
