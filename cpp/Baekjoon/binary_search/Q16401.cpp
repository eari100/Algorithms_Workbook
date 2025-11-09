#include <algorithm>
#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/16401 (과자 나눠주기)
 * @classification: binary search
 * @문제 푼 날짜 (자력으로 풂?): 25.11.09 (O)
 **/
int m, n, answer = 0;
vector<int> snack;

int main()
{
    cin>>m>>n;

    snack.resize(n);
    for (int i=0;i<n;i++)
    {
        cin>>snack[i];
    }

    sort(snack.begin(), snack.end());

    int l = 1, r = snack[snack.size()-1];

    while (l <= r)
    {
        int mid = (l+r) >> 1, share = 0;

        for (int j=0;j<snack.size();j++)
        {
            share += snack[j] / mid;
        }

        if (share >= m)
        {
            answer = mid;
            l = mid + 1;
        }
        else
        {
            r = mid - 1;
        }
    }

    cout << answer;
}