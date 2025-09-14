#include<iostream>
#include<vector>

using namespace std;

int t, k;
string str;

/**
 * @source: https://www.acmicpc.net/problem/20437 (문자열 게임 2)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.09.14 (O)
 **/
int main()
{
    cin>>t;

    while(t--)
    {
        int _min = 10001, _max = 0;
        vector<vector<int>> board(26);
        cin>>str>>k;

        for (int i=0; i<str.length(); i++)
        {
            int index = str[i] - 'a';
            board[index].push_back(i);
        }

        for (int i=0;i<26;i++)
        {
            if (board[i].size() < k) continue;

            for (int j=k-1;j<board[i].size();j++)
            {
                int _len = board[i][j] - board[i][j-k+1] + 1;
                _min = min(_min, _len);
                _max = max(_max, _len);
            }
        }

        if (_min == 10001)
        {
            cout << -1 << '\n';
        }
        else
        {
            cout << _min << ' ' << _max << '\n';
        }
    }
}