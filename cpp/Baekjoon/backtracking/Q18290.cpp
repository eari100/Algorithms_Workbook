#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/18290 (NM과 K (1))
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 25.12.05 (O)
 **/
int n, m, k, answer = -50'000;
int board[130];
vector<int> tmp;

void bt(int idx, int val, int depth)
{
    if (depth == k)
    {
        answer = max(answer, val);
        return;
    }

    for (int i=idx+1;i<n*m;i++)
    {
        bool possible = true;

        for (int idx2 : tmp)
        {
            int left = idx2 - 1;
            if (idx2 % m && i == left)
            {
                possible = false;
                break;
            }

            int right = idx2 + 1;
            if ( (idx2+1) % m && i == right )
            {
                possible = false;
                break;
            }

            int up = idx2 - m;
            int down = idx2 + m;

            if (i == idx2 || i == up || i == down)
            {
                possible = false;
                break;
            }
        }

        if (possible)
        {
            tmp.push_back(i);
            bt(i, val + board[i], depth+1);
            tmp.pop_back();
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n>>m>>k;

    for (int i=0;i<n*m;i++)
    {
        cin>>board[i];
    }

    for (int i=0;i<n*m;i++)
    {
        tmp.push_back(i);
        bt(i, board[i], 1);
        tmp.pop_back();
    }

    cout << answer;
}