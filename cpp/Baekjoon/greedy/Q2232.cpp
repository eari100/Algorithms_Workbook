#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2232 (지뢰)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.12.05 (O)
 **/
int n, mine[50'000+1], remain;
priority_queue<pair<int,int>> q;
bool boom[50'000+1];
vector<int> answer;

int main()
{
    cin>>n;
    remain = n;

    for (int i=0;i<n;i++)
    {
        cin>>mine[i];
        q.push({mine[i], i});
    }

    while (q.size() && remain)
    {
        pair<int, int> t = q.top();
        q.pop();

        if ( !boom[t.second] )
        {
            boom[t.second] = true;
            answer.push_back(t.second+1);
            --remain;

            int l = t.second - 1;
            int r = t.second + 1;

            while (l >= 0)
            {
                if (boom[l] || mine[l] >= mine[l+1])
                {
                    break;
                }

                boom[l] = true;

                --remain;
                l--;
            }

            while (r < n)
            {
                if (boom[r] || mine[r] >= mine[r-1])
                {
                    break;
                }

                boom[r] = true;

                --remain;
                r++;
            }
        }
    }

    sort(answer.begin(), answer.end());

    for (int i : answer)
    {
        cout << i << '\n';
    }
}