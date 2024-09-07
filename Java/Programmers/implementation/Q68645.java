package Programmers.implementation;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/68645 (삼각 달팽이)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.09.07 (O)
 **/
public class Q68645 {
    public int[] solution(int n) {
        int length = n * (n + 1) / 2;
        int[] answer = new int[length];
        int num = 0;
        int[] move = new int[3];
        int mIndex = 0;
        int aIndex = 0;

        while(++num <= length) {
            if(mIndex == 0) {
                int up = move[0];
                int next = aIndex + up;

                if(next < length && answer[next] == 0) {
                    aIndex = next;
                    answer[aIndex] = num;
                    ++move[0];
                } else {
                    move[2] = move[0];
                    --num;
                    mIndex = 1;
                }
            } else if(mIndex == 1) {
                int next = aIndex + 1;

                if(next < length && answer[next] == 0) {
                    aIndex = next;
                    answer[aIndex] = num;
                } else {
                    --num;
                    mIndex = 2;
                }
            } else if(mIndex == 2) {
                int down = move[2];
                int next = aIndex - down;

                if(next > 0 && answer[next] == 0) {
                    aIndex = next;
                    answer[aIndex] = num;
                    --move[2];
                } else {
                    move[0] = move[2];
                    --num;
                    mIndex = 0;
                }
            }
        }

        return answer;
    }
}
