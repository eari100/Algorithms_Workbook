package leetcode.binarySearch.parametricSearch;

/**
 * @source: https://leetcode.com/problems/first-bad-version/ (278. First Bad Version)
 * @classfication: parametric search
 * @문제 푼 날짜 (자력으로 풂?): 23.10.03 (O)
 **/
public class Q278 {
    public int firstBadVersion(int n) {
        long str = 1;
        long end = n;
        int result = 1;

        while(str <= end) {
            long mid = (str + end) / 2;
            int midI = (int) mid;

            if(isBadVersion(midI)) {
                end = mid-1;
                result = midI;
            } else {
                str = mid+1;
            }
        }

        return result;
    }

    private boolean isBadVersion(int version) {
        return false;
    }
}
