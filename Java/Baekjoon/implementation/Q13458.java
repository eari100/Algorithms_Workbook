package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/13458 (시험 감독)
 * @classfication: implementation
 * @reference: https://www.acmicpc.net/source/12608185 (실행속도 & 가독성 둘다 잡은 수식 풀이)
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 23.01.14 (O, 실수 범위형 오류는 참고함)
 **/
public class Q13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] testRoomPersonCnts = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++)
            testRoomPersonCnts[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        br.close();

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long examSupervisorsCnt = N;

        for(int testRoomPersonCnt : testRoomPersonCnts) {
            testRoomPersonCnt -= B;

            if(testRoomPersonCnt <= 0) continue;

            examSupervisorsCnt += testRoomPersonCnt / C;
            if(testRoomPersonCnt % C > 0) examSupervisorsCnt += 1;
        }

        System.out.print(examSupervisorsCnt);
    }
}
