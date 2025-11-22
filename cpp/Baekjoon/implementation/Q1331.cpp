#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1331 (나이트 투어)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.11.22 (O)
 **/
int x1, y1, x2, y2, goal_x, goal_y;
string dir;
int board_size = 6;
int knights[8][2] = {
    {-1, -2}, {-2, -1},
    {-2, 1}, {-1, 2},
    {1, 2}, {2, 1},
    {2, -1}, {1, -2},
};

bool visited[6][6];

int get_h(char c)
{
    int to_int = c - '0';

    return 6 - to_int;
}

int get_w(char c)
{
    return c - 'A';
}

int main()
{
    cin>>dir;
    x1 = get_h(dir[1]);
    y1 = get_w(dir[0]);
    visited[x1][y1] = true;
    goal_x = x1;
    goal_y = y1;

    for (int i=1;i<36;i++)
    {
        cin>>dir;
        x2 = get_h(dir[1]);
        y2 = get_w(dir[0]);
        bool correct = false;

        if (visited[x2][y2])
        {
            cout << "Invalid";
            return 0;
        }

        for (int j=0;j<8;j++)
        {
            int tmp_x = x1 + knights[j][0];
            int tmp_y = y1 + knights[j][1];

            if (tmp_x < 0 || tmp_x >= board_size || tmp_y < 0 || tmp_y >= board_size)
            {
                continue;
            }

            if (x2 == tmp_x && y2 == tmp_y)
            {
                correct = true;
                x1 = tmp_x;
                y1 = tmp_y;
                visited[x1][y1] = true;
                break;
            }
        }

        if ( !correct )
        {
            cout << "Invalid";
            return 0;
        }
    }

    bool is_goal = false;

    for (int i=0;i<8;i++)
    {
        int tmp_x = x1 + knights[i][0];
        int tmp_y = y1 + knights[i][1];

        if (tmp_x == goal_x && tmp_y == goal_y)
        {
            is_goal = true;
            break;
        }
    }

    cout << (is_goal ? "Valid" : "Invalid");
}