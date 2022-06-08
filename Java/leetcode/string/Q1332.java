package leetcode.string;

/**
 * @source: https://leetcode.com/problems/remove-palindromic-subsequences/
 * @classfication: string
 * @reference:
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.05.27 (O, 영어 실력으로 이해가 부족했음)
 **/
public class Q1332 {
    public int removePalindromeSub(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString()) ? 1 : 2;
    }
}
