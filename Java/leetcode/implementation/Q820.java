package leetcode.implementation;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @source: https://leetcode.com/problems/short-encoding-of-words/ (820. Short Encoding of Words)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.20 (X, 데이터를 추가해가면서 결과를 도출하는 방법만 생각하지 말고 가결과를 만들어두고 데이터를 제거하는 사고가 필요)
 **/
public class Q820 {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        int result = 0;

        for(String word : words) {
            for(int i=1;i<word.length();i++) {
                set.remove(word.substring(i));
            }
        }

        for(String word : set) {
            result += word.length() + 1;
        }

        return result;
    }
}
