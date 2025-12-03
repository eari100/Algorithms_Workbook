#include<iostream>
#include<vector>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/30805 (사전 순 최대 공통 부분 수열)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.12.03 (O)
 **/
int n, m;
int tmp, idx1 = -1, idx2 = -1, target = 100;
vector<int> common;
vector<queue<int>> cc1(100+1), cc2(100+1);

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>>n;

    for (int i=0;i<n;i++)
    {
        cin>>tmp;
        cc1[tmp].push(i);
    }

    cin>>m;

    for (int i=0;i<m;i++)
    {
        cin>>tmp;
        cc2[tmp].push(i);
    }

    while (target)
    {
        int nx1 = -1, nx2 = -1;

        while (cc1[target].size())
        {
            nx1 = cc1[target].front();
            cc1[target].pop();

            if (nx1 > idx1)
            {
                break;
            }
        }

        while (cc2[target].size())
        {
            nx2 = cc2[target].front();
            cc2[target].pop();

            if (nx2 > idx2)
            {
                break;
            }
        }

        if (nx1 > idx1 && nx2 > idx2)
        {
            idx1 = nx1;
            idx2 = nx2;
            common.push_back(target);
        }
        else
        {
            target--;
        }
    }

    cout << common.size() << '\n';
    for (int item : common)
    {
        cout << item << ' ';
    }
}