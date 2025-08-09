#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2239 (스도쿠)
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 25.08.09 (X)
 **/
int board[9][9];
vector<vector<int>> zeros;

void bt(int zeros_index)
{
    if (zeros_index == zeros.size())
    {
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                cout << board[i][j];
            }

            cout << '\n';
        }

        exit(0);
    }

    for (int i=1;i<=9;i++)
    {
        bool check = true;
        for (int j=0;j<9;j++)
        {
            if (board[zeros[zeros_index][0]][j] == i || board[j][zeros[zeros_index][1]] == i)
            {
                check = false;
                break;
            }

            int share_x = zeros[zeros_index][0] / 3;
            int share_y = zeros[zeros_index][1] / 3;
            int share_j = j / 3;
            int remain_j = j % 3;

            if (board[share_x * 3 + share_j][share_y * 3 + remain_j] == i)
            {
                check = false;
                break;
            }
        }

        if (check)
        {
            board[zeros[zeros_index][0]][zeros[zeros_index][1]] = i;
            bt(zeros_index+1);
            board[zeros[zeros_index][0]][zeros[zeros_index][1]] = 0;
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string tmp;

    for (int i=0;i<9;i++)
    {
        cin >> tmp;
        for (int j=0;j<9;j++)
        {
            int num = tmp[j] - '0';
            board[i][j] = num;

            if (num == 0)
            {
                zeros.push_back({i, j});
            }
        }
    }

    bt(0);
}