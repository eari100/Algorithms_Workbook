package Programmers.implementation;

import java.util.HashMap;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/258712 (2024 KAKAO WINTER INTERNSHIP > 가장 많이 받은 선물)
 * @classification: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.15 (O)
 **/
public class Q258712 {
    public int solution(String[] friends, String[] gifts) {
        int giftMaxCnt = 0;
        int[] giftsCount = new int[friends.length];
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            hm.put(friends[i], i);
        }

        int[][] scores = new int[friends.length][gifts.length];

        for(String gift : gifts) {
            String[] aToB = gift.split(" ");
            String a = aToB[0], b = aToB[1];
            int index1 = hm.get(a), index2 = hm.get(b);

            ++scores[index1][index2];
        }

        for(int i=0;i<friends.length;i++) {
            for(int j=i+1;j<friends.length;j++) {
                int aToB = scores[i][j];
                int bToA = scores[j][i];

                if(aToB > bToA) {
                    ++giftsCount[i];
                    giftMaxCnt = Math.max(giftMaxCnt, giftsCount[i]);
                } else if(aToB < bToA) {
                    ++giftsCount[j];
                    giftMaxCnt = Math.max(giftMaxCnt, giftsCount[j]);
                } else {
                    int giftScore1 = getGiftScore(scores, i);
                    int giftScore2 = getGiftScore(scores, j);

                    if(giftScore1 < giftScore2) {
                        ++giftsCount[j];
                        giftMaxCnt = Math.max(giftMaxCnt, giftsCount[j]);
                    } else if(giftScore1 > giftScore2) {
                        ++giftsCount[i];
                        giftMaxCnt = Math.max(giftMaxCnt, giftsCount[i]);
                    }
                }
            }
        }

        return giftMaxCnt;
    }

    private int getGiftScore(int[][] scores, int index) {
        int giveCnt = 0;

        for(int score : scores[index]) {
            giveCnt += score;
        }

        int takeCnt = 0;

        for(int i=0;i<scores.length;i++) {
            takeCnt += scores[i][index];
        }

        return giveCnt - takeCnt;
    }
}
