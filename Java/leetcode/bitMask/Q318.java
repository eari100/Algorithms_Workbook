package leetcode.bitMask;

/**
 * @source: https://leetcode.com/problems/maximum-product-of-word-lengths/ (318. Maximum Product of Word Lengths)
 * @classfication: bitMask
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.05.29 (X)
 **/
public class Q318 {
    public static void main(String[] args) {
        Q318 q318 = new Q318();
        q318.maxProduct(new String[]{"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"});
        q318.maxProduct(new String[]{"a","aa","aaa","aaaa"});
    }

    public int maxProduct(String[] words) {
        int best = 0;
        int[] bitsets = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int wlen = words[i].length(), bitset = 0;
            for (int j = 0; j < wlen; j++)
                bitset |= 1 << (words[i].charAt(j) - 'a');

            for (int j = 0; j < i; j++)
                if ((bitsets[j] & bitset) == 0)
                    best = Math.max(best, wlen * words[j].length());
            bitsets[i] = bitset;
        }
        return best;
    }
}
