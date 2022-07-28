package leetcode.implementation;

/**
 * @source: https://leetcode.com/problems/valid-anagram/ (242. Valid Anagram)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.28 (O, Runtime: 7 ms, faster than 53.66%, Memory Usage: 43 MB, less than 84.83%)
 **/
public class Q242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] arr = new int[26];

        for(int i=0;i<s.length();i++) {
            ++arr[s.charAt(i) - 97];
            --arr[t.charAt(i) - 97];
        }

        for(int i : arr)
            if(i != 0) return false;

        return true;
    }
}
