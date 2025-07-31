#include<unordered_set>
#include<vector>

using namespace std;

/**
 * @source: https://leetcode.com/problems/bitwise-ors-of-subarrays/description/?envType=daily-question&envId=2025-07-31 (898. Bitwise ORs of Subarrays)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 25.07.31 (X)
 **/
class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        unordered_set<int> answer;
        unordered_set<int> prev;
        prev.insert(0);

        for(int a : arr) {
            unordered_set<int> curr;

            for(int p : prev) {
                curr.insert(a | p);
            }
            curr.insert(a);

            prev = unordered_set<int>();
            for(int c : curr)
            {
                answer.insert(c);
                prev.insert(c);
            }
        }

        return answer.size();
    }
};