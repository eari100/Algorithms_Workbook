package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @source: https://leetcode.com/problems/find-and-replace-pattern/submissions/ (890. Find and Replace Pattern)
 * @classfication: string
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.29 (O)
 **/
public class Q890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        HashMap<Character, Character> hashMap1;
        HashMap<Character, Character> hashMap2;
        List<String> answer = new ArrayList<>();

        for(String word : words) {
            hashMap1 = new HashMap<>();
            hashMap2 = new HashMap<>();
            boolean isAnswer = true;

            for(int i=0;i<pattern.length();i++) {
                char w = word.charAt(i);
                char p = pattern.charAt(i);

                if(hashMap1.containsKey(p)) {
                    if(hashMap1.get(p) != w) {
                        isAnswer = false;
                        break;
                    }
                } else {
                    hashMap1.put(p, w);
                }

                if(hashMap2.containsKey(w)) {
                    if(hashMap2.get(w) != p) {
                        isAnswer = false;
                        break;
                    }
                } else {
                    hashMap2.put(w, p);
                }
            }

            if(isAnswer) answer.add(word);
        }

        return answer;
    }
}
