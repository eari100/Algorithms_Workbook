package leetcode.implementation;

import java.util.Arrays;

/**
 * @source: https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/submissions/ (Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts)
 * @classfication: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.02 (O)
 **/
public class Q1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        final long mod = (long)1e9+7;

        Arrays.sort(horizontalCuts);
        long maxWidth = horizontalCuts[0];

        for(int i=1;i<horizontalCuts.length;i++) {
            maxWidth = Math.max(maxWidth, horizontalCuts[i] - horizontalCuts[i-1]);
        }

        maxWidth = Math.max(maxWidth, h - horizontalCuts[horizontalCuts.length-1]);

        Arrays.sort(verticalCuts);
        long maxHeight = verticalCuts[0];

        for(int i=1;i<verticalCuts.length;i++) {
            maxHeight = Math.max(maxHeight, verticalCuts[i] - verticalCuts[i-1]);
        }

        maxHeight = Math.max(maxHeight, w - verticalCuts[verticalCuts.length-1]);

        return (int) ((maxWidth * maxHeight) % mod);
    }
}
