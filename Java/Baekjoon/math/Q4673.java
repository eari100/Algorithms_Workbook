package Baekjoon.math;

import java.io.IOException;

/**
 * @source: https://www.acmicpc.net/problem/4673 (셀프 넘버)
 * @classfication: math, implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.04.28 (O, 수식 세우는 데 시간이 걸림)
 **/
public class Q4673 {
    public static void main(String[] args) throws IOException {
        boolean[] constructorNums = new boolean[10000+1];

        for(int i=1;i<10000+1;i++) {
            int num = i;

            while(num < 10000) {
                int numLen = (int) Math.log10(num);
                int numTmp = num;

                for(int j=0;j<numLen+1;j++) {
                    num += numTmp / Math.pow(10, j) % 10;;
                }

                if(num > 10000) continue;
                if(constructorNums[num]) continue;

                constructorNums[num] = true;
            }
        }

        StringBuilder selfNumbers = new StringBuilder();

        for(int i=1;i<constructorNums.length;i++) {
            if(!constructorNums[i]) selfNumbers.append(i).append('\n');
        }

        System.out.print(selfNumbers);
    }
}
