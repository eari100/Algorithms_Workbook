package Baekjoon.math.probabilityTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/28682 (재우야 임관하자)
 * @classfication: probability theory, ad hok, monty hall problem, math
 * @문제 푼 날짜 (자력으로 풂?): 23.08.20 (O)
 **/
public class Q28682 {
    static final String swimming = "swimming";
    static final String bowling = "bowling";
    static final String soccer  = "soccer";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder 재우들이_선택한_과목들 = new StringBuilder();

        for(int i=0;i<N;i++) {
            재우들이_선택한_과목들.append(swimming).append(' ');
        }

        System.out.println(재우들이_선택한_과목들);
        System.out.flush();

        String[] F_과목들 = br.readLine().split(" ");
        StringBuilder pass_과목들 = new StringBuilder();

        for(String F_과목 : F_과목들) {
            if(F_과목.equals(bowling)) {
                pass_과목들.append(soccer).append(' ');
            } else if(F_과목.equals(soccer)) {
                pass_과목들.append(bowling).append(' ');
            }
        }

        br.close();

        System.out.println(pass_과목들);
    }
}

