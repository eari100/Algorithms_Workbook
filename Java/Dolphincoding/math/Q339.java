package Dolphincoding.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://dolphincoding.eduenv.com/learn/problem/339 (울타리 칠하기)
 * @classfication: math
 * @문제 푼 날짜 (자력으로 풂?): 23.08.08 (O)
 **/
public class Q339 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        int sumLength = 0;

        sumLength += y1 - x1;

        if(x2 >= y1 || y2 <= x1) {
            sumLength += y2 - x2;
        } else {
            if(x2 < x1 && y2 > x1) {
                sumLength += x1 - x2;
            }

            if(x2 < y1 && y2 > y1) {
                sumLength += y2 - y1;
            }
        }

        System.out.print(sumLength);
    }
}
