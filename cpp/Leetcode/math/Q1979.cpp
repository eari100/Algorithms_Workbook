/**
 * @source: https://leetcode.com/problems/find-greatest-common-divisor-of-array/?envType=daily-question&envId=2026-07-19 (1979. Find Greatest Common Divisor of Array)
 * @classification: GCD
 **/
class Solution {
public:
    int GCD(int a, int b) {
        if(!b) {
            return a;
        }

        return GCD(b, a%b);
    }

    int findGCD(vector<int>& nums) {
        int _min = 1001, _max = 0;

        for(int& num : nums) {
            _min = min(_min, num);
            _max = max(_max, num);
        }

        return GCD(_min, _max);
    }
};