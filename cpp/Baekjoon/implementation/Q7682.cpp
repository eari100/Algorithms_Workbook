#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/7682 (틱택토)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.09.14 (O)
 **/
string log, VALID = "valid", INVALID = "invalid";

int main()
{
    while(1)
    {
      cin>>log;
      if(log == "end") break;

        vector<vector<char>> board(3, vector<char>(3, '.'));

        int f_cnt = 0, s_cnt = 0;
        for(int i=0;i<9;i++)
        {
            int x = i / 3;
            int y = i % 3;
            board[x][y] = log[i];

            if (log[i] == 'X')
            {
                f_cnt++;
            }
            else if (log[i] == 'O')
            {
                s_cnt++;
            }
        }

        if (f_cnt < s_cnt )
        {
            cout << INVALID << '\n';
            continue;
        }

        if (f_cnt - s_cnt > 1)
        {
            cout << INVALID << '\n';
            continue;
        }

        // 누가 이겼는지 확인
        bool f_win = false, s_win = false;

        // 가로
        if ( (board[0][0] == board[0][1]) && (board[0][1] == board[0][2]))
        {
            if (board[0][0] == 'X')
            {
                f_win = true;
            }
            else if (board[0][0] == 'O')
            {
                s_win = true;
            }
        }
        if ( (board[1][0] == board[1][1]) && (board[1][1] == board[1][2]))
        {
            if (board[1][0] == 'X')
            {
                f_win = true;
            }
            else if (board[1][0] == 'O')
            {
                s_win = true;
            }
        }
        if ( (board[2][0] == board[2][1]) && (board[2][1] == board[2][2]))
        {
            if (board[2][0] == 'X')
            {
                f_win = true;
            }
            else if (board[2][0] == 'O')
            {
                s_win = true;
            }
        }

        // 세로
        if ( (board[0][0] == board[1][0]) && (board[1][0] == board[2][0]))
        {
            if (board[0][0] == 'X')
            {
                f_win = true;
            }
            else if (board[0][0] == 'O')
            {
                s_win = true;
            }
        }
        if ( (board[0][1] == board[1][1]) && (board[1][1] == board[2][1]))
        {
            if (board[0][1] == 'X')
            {
                f_win = true;
            }
            else if (board[0][1] == 'O')
            {
                s_win = true;
            }
        }
        if ( (board[0][2] == board[1][2]) && (board[1][2] == board[2][2]))
        {
            if (board[0][2] == 'X')
            {
                f_win = true;
            }
            else if (board[0][2] == 'O')
            {
                s_win = true;
            }
        }

        // 대각선
        if ( (board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) )
        {
            if (board[0][0] == 'X')
            {
                f_win = true;
            }
            else if (board[0][0] == 'O')
            {
                s_win = true;
            }
        }
        if ( (board[0][2] == board[1][1]) && (board[1][1] == board[2][0]) )
        {
            if (board[0][2] == 'X')
            {
                f_win = true;
            }
            else if (board[0][2] == 'O')
            {
                s_win = true;
            }
        }

        // 둘다 이김
        if (f_win && s_win)
        {
            cout << INVALID << '\n';
            continue;
        }

        // 둘다 짐
        if ( !f_win && !s_win)
        {
            if (f_cnt + s_cnt != 9)
            {
                cout << INVALID << '\n';
                continue;
            }
        }

        if (f_win)
        {
            if (f_cnt == s_cnt)
            {
                cout << INVALID << '\n';
                continue;
            }
        }

        if (s_win)
        {
            if (f_cnt > s_cnt)
            {
                cout << INVALID << '\n';
                continue;
            }
        }

        cout << VALID << '\n';
    }
}