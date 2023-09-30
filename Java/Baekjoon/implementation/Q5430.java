package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/5430 (AC)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.10.01 (O)
 **/
// todo: deque 자료구조를 이용해서 풀어보자
public class Q5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        final String error = "error";

        for(int i=0;i<T;i++) {
            String p = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            arrStr = arrStr.substring(1, arrStr.length()-1);
            String[] arr = len == 0 ? new String[0] : arrStr.split(",");
            boolean isReverse = false;
            int str = 0;
            int end = arr.length-1;

            for(int k=0;k<p.length();k++) {
                char prompt = p.charAt(k);

                if (prompt == 'R') {
                    isReverse = !isReverse;
                } else if (prompt == 'D') {
                    if(str > end) {
                        result.append(error).append('\n');
                        break;
                    } else {
                        if( !isReverse ) {
                            str += 1;
                        } else {
                            end -= 1;
                        }
                    }
                }

                if(k == p.length()-1) {
                    result.append('[');

                    if( !isReverse ) {
                        for(int l=str;l<=end;l++) {
                            result.append(arr[l]);

                            if(l < end)
                                result.append(',');
                        }
                        result.append(']').append('\n');
                    } else {
                        for(int l=end;l>=str;l--) {
                            result.append(arr[l]);

                            if(l > str)
                                result.append(',');
                        }
                        result.append(']').append('\n');
                    }
                }
            }
        }

        br.close();

        System.out.print(result);
    }
}
