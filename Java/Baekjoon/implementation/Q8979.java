package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/8979 (올림픽)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.03.03 (X, 시간 초과)
 **/
public class Q8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Nation[] nations = new Nation[N];

        int tmpRank = 1;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int nationNo = Integer.parseInt(st.nextToken());
            int goldCnt = Integer.parseInt(st.nextToken());
            int silverCnt = Integer.parseInt(st.nextToken());
            int bronzeCnt = Integer.parseInt(st.nextToken());

            nations[i] = new Nation(nationNo, goldCnt, silverCnt, bronzeCnt);
        }

        br.close();

        Arrays.sort(nations, (nation1, nation2) -> {
           if(nation1.getGoldCnt() == nation2.getGoldCnt()) {
               if(nation1.getSilverCnt() == nation2.getSilverCnt()) {
                   if(nation1.getBronzeCnt() == nation2.getBronzeCnt()) {
                       return 0;
                   } else {
                       return nation2.getBronzeCnt() - nation1.getBronzeCnt();
                   }
               } else {
                   return nation2.getSilverCnt() - nation1.getSilverCnt();
               }
           } else {
               return nation2.getGoldCnt() - nation1.goldCnt;
           }
        });

        for(int i=1;i<nations.length;i++) {
            Nation nation1 = nations[i-1];
            Nation nation2 = nations[i];

            if(!nation1.같은_등수인가(nation2)) ++tmpRank;

            if(nation2.getNationNo() == K) break;
        }

        System.out.print(tmpRank);
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

        public int getNationNo() {
            return nationNo;
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

        public boolean 같은_등수인가(Nation nation) {
            boolean 같은_등수_여부 = this.goldCnt == nation.getGoldCnt() && this.silverCnt == nation.getSilverCnt() && this.bronzeCnt == nation.getBronzeCnt();
            return 같은_등수_여부;
        }
    }
}
