package Atcoder.AtCoder_Beginner_contest_318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://atcoder.jp/contests/abc318/tasks/abc318_c (C - Blue Spring)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.09.03 (O, 침착하게 index 제대로 지정할 것)
 **/
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        long total = 0;

        int[] moneys = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            int money = Integer.parseInt(st.nextToken());;
            moneys[i] = money;
            total += money;
        }

        br.close();

        Arrays.sort(moneys);

        long sumSum = 0;

        int count = 0;
        L1: for(int i=N-1;i>=0;i-=D) {
            long sum = 0;
            for(int j=0;j<D;j++) {
                int index = i - j;
                if(index < 0) {

                    if(sum > P) {
                        ++count;
                        sumSum += sum;
                    }
                    break L1;
                }

                sum += moneys[index];
            }

            if(sum < P) {
                break;
            }
            ++count;
            sumSum += sum;
        }


        long total2 = total - sumSum + ((long) P * count);

        System.out.println(Math.min(total2, total));
    }
}
