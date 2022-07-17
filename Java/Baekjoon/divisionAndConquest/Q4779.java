package Baekjoon.divisionAndConquest;

import java.io.*;

/**
 * @source: https://www.acmicpc.net/problem/4779 (칸토어 집합)
 * @classfication: division and conquest, recursive
 * @reference: https://www.acmicpc.net/source/share/35e189bbbf7849ec88cfe74714cb8bc4
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.18 (X)
 **/
public class Q4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";

        while((input=br.readLine()) != null) {
            boolean[] list = new boolean[531441]; // false: '-', true: ' '

            int N = Integer.parseInt(input);
            int pow = (int) Math.pow(3, N);

            makeCantorSet(list, 0, pow-1);

            for(int i=0;i<pow;i++) {
                bw.write(list[i] ? ' ' : '-');
            }

            bw.write("\n");
            bw.flush();
        }

        br.close();
    }

    private static void makeCantorSet(boolean[] list, int str, int end) {
        if(str==end) return;

        int length = end+1 - str;
        int threePart = length/3;

        for(int i=str+threePart;i<=end-threePart;i++) {
            list[i] = true;
        }

        makeCantorSet(list, str, str+threePart-1);
        makeCantorSet(list, end-threePart+1, end);
    }
}
