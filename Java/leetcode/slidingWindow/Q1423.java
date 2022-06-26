package leetcode.slidingWindow;

/**
 * @source: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/submissions/ (1423. Maximum Points You Can Obtain from Cards)
 * @classfication: sliding window
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.26 (X)
 **/
public class Q1423 {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0;
        int currSum = 0;
        int minSubArray = 0;

        for(int i=0;i<cardPoints.length;i++) {
            totalSum += cardPoints[i];
            currSum += cardPoints[i];

            if(i < cardPoints.length - k) {
                minSubArray = currSum;
            } else {
                currSum-=cardPoints[i-(cardPoints.length-k)];
                minSubArray = Math.min(minSubArray, currSum);

            }
        }

        return totalSum - minSubArray;
    }
}
