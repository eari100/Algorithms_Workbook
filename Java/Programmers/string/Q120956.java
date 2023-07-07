package Programmers.string;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/120956 (옹알이 (1))
 * @classfication: string
 * @문제 푼 날짜 (자력으로 풂?): 23.07.08 (X)
 **/
public class Q120956 {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for(String b : babbling) {
            for(String w : words) {
                b = b.replaceFirst(w, "1");
            }

            b = b.replace("1", "");

            if(b.isEmpty()) ++answer;
        }

        return answer;
    }
}
