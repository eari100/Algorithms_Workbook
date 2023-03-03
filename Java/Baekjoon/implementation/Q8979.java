package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/8979 (올림픽)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.03.03 (X)
 **/
public class Q8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Nation[] nations = new Nation[N];
        Nation targetNation = null;
        int kRank = 1;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int nationNo = Integer.parseInt(st.nextToken());
            int goldCnt = Integer.parseInt(st.nextToken());
            int silverCnt = Integer.parseInt(st.nextToken());
            int bronzeCnt = Integer.parseInt(st.nextToken());

            nations[i] = new Nation(nationNo, goldCnt, silverCnt, bronzeCnt);

            if(K == nationNo) targetNation = nations[i];
        }

        br.close();

        int targetGoldCnt = targetNation.getGoldCnt();
        int targetSilverCnt = targetNation.getSilverCnt();
        int targetBronzeCnt = targetNation.getBronzeCnt();


        for(int i=0;i<nations.length;i++) {
            Nation nation = nations[i];
            int nGoldCnt = nation.getGoldCnt();
            int nSilverCnt = nation.getSilverCnt();
            int nBronzeCnt = nation.getBronzeCnt();

            if(targetGoldCnt < nGoldCnt) ++kRank;
            else if(targetGoldCnt == nGoldCnt) {
                if(targetSilverCnt < nSilverCnt) ++kRank;
                else if(targetSilverCnt == nSilverCnt) {
                    if(targetBronzeCnt < nBronzeCnt) ++kRank;
                }
            }
        }

        System.out.print(kRank);
    }

    public static class Nation {
        private int nationNo;
        private int goldCnt;
        private int silverCnt;
        private int bronzeCnt;

        public Nation(int nationNo, int goldCnt, int silverCnt, int bronzeCnt) {
            this.nationNo = nationNo;
            this.goldCnt = goldCnt;
            this.silverCnt = silverCnt;
            this.bronzeCnt = bronzeCnt;
        }

        public int getGoldCnt() {
            return goldCnt;
        }

        public int getSilverCnt() {
            return silverCnt;
        }

        public int getBronzeCnt() {
            return bronzeCnt;
        }
    }
}
