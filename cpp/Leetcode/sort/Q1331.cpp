#include<vector>
#include<algorithm>

using namespace std;

/**
 * @source: https://leetcode.com/problems/rank-transform-of-an-array/description (1331. Rank Transform of an Array)
 * @classification: sort
 * @문제 푼 날짜 (자력으로 풂?): 26.07.17 (O)
 * Runtime: 60ms, Beats 26.72%
 * Memory: 48.25MB, Beats 12.94%
 **/
struct comp {
    bool operator()(vector<int>& a, vector<int>& b) {
        return a[1] < b[1];
    }
};

class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        vector<vector<int>> sorted_arr(arr.size(), vector<int>(2));
        vector<int> ranking(arr.size(), 0);

        for(int i=0;i<arr.size();i++) {
            sorted_arr[i] = {i, arr[i]};
        }

        sort(sorted_arr.begin(), sorted_arr.end(), comp());

        int rank = 1;
        for(int i=0;i<sorted_arr.size();i++) {
            if(i && sorted_arr[i-1][1] < sorted_arr[i][1]) {
                ++rank;
            }

            ranking[sorted_arr[i][0]] = rank;
        }

        return ranking;
    }
};