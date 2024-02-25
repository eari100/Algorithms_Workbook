package Programmers.backtracking;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12952 (N-Queen)
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 24.02.25 (O)
 **/
public class Q12952 {
    static int[] memo;
    static int answer = 0;

    public int solution(int n) {
        memo = new int[n];

        bt(0);
        return answer;
    }

    private void bt(int depth) {
        if(depth == memo.length) {
            ++answer;
            return;
        }

        L1: for(int curr=0;curr<memo.length;curr++) {
            for(int y=0;y<depth;y++) { // memo 순회
                int x = memo[y];
                if(curr == x) continue L1;

                int add = depth-y;
                if(curr == x+add && depth == y+add) continue L1;
                if(curr == x-add && depth == y+add) continue L1;
            }

            memo[depth] = curr;
            bt(depth+1);
        }
    }
}
