package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/17478 (재귀함수가 뭔가요?)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.04.30 (O)
 **/
public class Q17478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder result = new StringBuilder();
        result.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append('\n')
                .append(recursive(0, N));

        System.out.print(result);
    }

    private static StringBuilder recursive(int callCnt, int maxCallCnt) {
        String underBar = makeUnderBar(callCnt);
        StringBuilder result = new StringBuilder();

        if(callCnt == maxCallCnt) {
            result.append(underBar).append("\"재귀함수가 뭔가요?\"").append('\n')
                    .append(underBar).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append('\n')
                    .append(underBar).append("라고 답변하였지.").append('\n');
            return result;
        }

        return result.append(underBar).append("\"재귀함수가 뭔가요?\"").append('\n')
                .append(underBar).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append('\n')
                .append(underBar).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append('\n')
                .append(underBar).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append('\n')
                .append(recursive(callCnt+1, maxCallCnt))
                .append(underBar).append("라고 답변하였지.").append('\n');
    }

    private static String makeUnderBar(int repeat) {
        StringBuilder underBar = new StringBuilder();

        for(int i=0;i<repeat;i++)
            underBar.append("____");

        return underBar.toString();
    }
}
