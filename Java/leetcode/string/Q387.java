package leetcode.string;

/**
 * @source: https://leetcode.com/problems/first-unique-character-in-a-string/solution/
 * @classfication: string
 * @reference:
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.08.16 (O, Runtime: 88 ms, faster than 6.59% Memory Usage: 48.8 MB, less than 59.90%)
 **/
public class Q387 {
    public int firstUniqChar(String s) {
        if(s.length()==1) return 0;

        int index = -1;

        Loop1: for(int i=0;i<s.length();i++) {
            for(int j=0;j<s.length();j++) {
                if(i==j) {
                    if(j == s.length()-1) index = i;
                    else continue;
                }

                if(s.charAt(i) == s.charAt(j)) break;
                if(j == s.length()-1) {
                    index = i;
                    break Loop1;
                }
            }
        }

        return index;
    }
}
