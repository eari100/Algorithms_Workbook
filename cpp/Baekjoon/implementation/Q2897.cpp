#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1957 (몬스터 트럭)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.11.21 (O)
 **/
int r, c, answer[5];
char board[50][50];
string s;

int main()
{
    cin>>r>>c;

    getline(cin, s);
    for (int i=0;i<r;i++)
    {
        getline(cin, s);
        for (int j=0;j<c;j++)
        {
            board[i][j] = s[j];
        }
    }

    for (int i=0;i<r-1;i++)
    {
        for (int j=0;j<c-1;j++)
        {
            char c1 = board[i][j];
            char c2 = board[i][j+1];
            char c3 = board[i+1][j];
            char c4 = board[i+1][j+1];

            if (c1 == '#' || c2 == '#' || c3 == '#' || c4 == '#')
            {
                continue;
            }

            int car = 0;

            if (c1 == 'X')
            {
                car++;
            }

            if (c2 == 'X')
            {
                car++;
            }

            if (c3 == 'X')
            {
                car++;
            }

            if (c4 == 'X')
            {
                car++;
            }

            answer[car]++;
        }
    }

    for (int i=0;i<5;i++)
    {
        cout << answer[i] << '\n';
    }
}