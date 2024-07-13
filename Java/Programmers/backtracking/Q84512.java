package Programmers.backtracking;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/84512 (모음사전)
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 24.07.13 (O, 푸는데 오래 걸림)
 **/
public class Q84512 {
    static final char[] chars = {'A', 'E', 'I', 'O', 'U'};
    static int answer = 0;

    public int solution(String word) {
        bt(0, new char[5], word);
        return answer;
    }

    private boolean bt(int depth, char[] tempWord, String word) {
        for(int i=0;i<chars.length;i++) {
            ++answer;
            tempWord[depth] = chars[i];

            if(depth+1 == word.length()) {
                if(isEqual(word, tempWord)) {
                    return true;
                }
            }

            if(depth+1 < tempWord.length) {
                if(bt(depth+1, tempWord, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isEqual(String word, char[] tempWord) {
        for(int j=0;j<word.length();j++) {
            char c1 = word.charAt(j);
            char c2 = tempWord[j];

            if(c1 != c2) {
                return false;
            }
        }

        return true;
    }
}
