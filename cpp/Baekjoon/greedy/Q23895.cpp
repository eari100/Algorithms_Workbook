#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/23895 (Allocation)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.11.15 (O)
 **/
int t, cnt, money, cell, tmp_h;

int main()
{
    cin>>t;

    for (int i=1;i<=t;i++)
    {
        cell = 0;
        vector<int> house;
        cin>>cnt>>money;
        for (int j=0;j<cnt;j++)
        {
            cin>>tmp_h;
            house.push_back(tmp_h);
        }

        sort(house.begin(), house.end());


        for (int j=0;j<cnt;j++)
        {
            if (money < house[j])
            {
                break;
            }

            ++cell;
            money -= house[j];
        }

        cout << "Case #" << i << ": " << cell << '\n';
    }
}