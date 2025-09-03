#include <iostream>
#include <vector>
#include <queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/13460 (구슬 탈출 2)
 * @classification: implementation, bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.09.03 (O)
 **/
int h, w, _empty = 0, wall = 1, hole = 2;
int blue_color = 0, red_color = 1;

vector<int> red(2), blue(2);
vector<vector<int>> board; // 1: 벽, 0: 빈공간, 2: 구멍
queue<vector<int>> que; // {red}, {blue}, 횟수
int moves[4][2] =
{
    {-1, 0}, {0, 1}, {1, 0}, {0, -1}
};

vector<int> get_next_point(int x, int y, int xx, int yy, int dir)
{
    int x2 = x, y2 = y;

    while (board[x2][y2] == _empty)
    {
        int x3 = x2 + moves[dir][0];
        int y3 = y2 + moves[dir][1];

        if (x3 < 0 || x3 >= board.size() || y3 < 0 || y3 >= board[0].size())
        {
            break;
        }

        // 다른 구슬에 부딫쳤다면
        if (x3 == xx && y3 == yy)
        {
            break;
        }

        if (board[x3][y3] == wall)
        {
            break;
        }

        if (board[x3][y3] == hole)
        {
            x2 = -1;
            y2 = -1;
            break;
        }

        x2 = x3;
        y2 = y3;
    }

    return {x2, y2};
}

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin >> h >> w;
    board = vector<vector<int>>(h, vector<int>(w, 0));

    for (int i=0;i<h;i++)
    {
        string row;
        cin >> row;
        for (int j=0;j<w;j++)
        {
            if (row[j] == '#')
            {
                board[i][j] = wall;
            }
            else if (row[j] == 'O')
            {
                board[i][j] = hole;
            }
            else if (row[j] == 'R')
            {
                red[0] = i;
                red[1] = j;
                board[i][j] = _empty;
            }
            else if (row[j] == 'B')
            {
                blue[0] = i;
                blue[1] = j;
                board[i][j] = _empty;
            }
            else
            {
                board[i][j] = _empty;
            }
        }
    }

    que.push({red[0], red[1], blue[0], blue[1], 0});

    while (!que.empty())
    {
        vector<int> _front = que.front();
        int red_x = _front[0];
        int red_y = _front[1];
        int blue_x = _front[2];
        int blue_y = _front[3];
        int count = _front[4];
        que.pop();


        for (int i=0;i<4;i++)
        {
            int red_x_2, red_y_2, blue_x_2, blue_y_2;

            // 어느쪽이 기울임에 가까운지 파악
            if (i == 0)
            {
                // red부터
                if (red_x < blue_x)
                {
                    vector<int> next_red = get_next_point(red_x, red_y, blue_x, blue_y, i);
                    red_x_2 = next_red[0];
                    red_y_2 = next_red[1];

                    vector<int> next_blue = get_next_point(blue_x, blue_y, red_x_2, red_y_2, i);
                    blue_x_2 = next_blue[0];
                    blue_y_2 = next_blue[1];
                }
                // blue 부터
                else
                {
                    vector<int> next_blue = get_next_point(blue_x, blue_y, red_x, red_y, i);
                    blue_x_2 = next_blue[0];
                    blue_y_2 = next_blue[1];

                    vector<int> next_red = get_next_point(red_x, red_y, blue_x_2, blue_y_2, i);
                    red_x_2 = next_red[0];
                    red_y_2 = next_red[1];
                }
            }
            else if (i == 1) // 오
            {
                // red 부터
                if (red_y > blue_y)
                {
                    vector<int> next_red = get_next_point(red_x, red_y, blue_x, blue_y, i);
                    red_x_2 = next_red[0];
                    red_y_2 = next_red[1];

                    vector<int> next_blue = get_next_point(blue_x, blue_y, red_x_2, red_y_2, i);
                    blue_x_2 = next_blue[0];
                    blue_y_2 = next_blue[1];
                }
                else
                {
                    vector<int> next_blue = get_next_point(blue_x, blue_y, red_x, red_y, i);
                    blue_x_2 = next_blue[0];
                    blue_y_2 = next_blue[1];

                    vector<int> next_red = get_next_point(red_x, red_y, blue_x_2, blue_y_2, i);
                    red_x_2 = next_red[0];
                    red_y_2 = next_red[1];
                }
            }
            else if (i == 2) // 하
            {
                if (red_x > blue_x)
                {
                    vector<int> next_red = get_next_point(red_x, red_y, blue_x, blue_y, i);
                    red_x_2 = next_red[0];
                    red_y_2 = next_red[1];

                    vector<int> next_blue = get_next_point(blue_x, blue_y, red_x_2, red_y_2, i);
                    blue_x_2 = next_blue[0];
                    blue_y_2 = next_blue[1];
                }
                else
                {
                    vector<int> next_blue = get_next_point(blue_x, blue_y, red_x, red_y, i);
                    blue_x_2 = next_blue[0];
                    blue_y_2 = next_blue[1];

                    vector<int> next_red = get_next_point(red_x, red_y, blue_x_2, blue_y_2, i);
                    red_x_2 = next_red[0];
                    red_y_2 = next_red[1];
                }
            }
            else if (i == 3) // 좌
            {
                if (red_y < blue_y)
                {
                    vector<int> next_red = get_next_point(red_x, red_y, blue_x, blue_y, i);
                    red_x_2 = next_red[0];
                    red_y_2 = next_red[1];

                    vector<int> next_blue = get_next_point(blue_x, blue_y, red_x_2, red_y_2, i);
                    blue_x_2 = next_blue[0];
                    blue_y_2 = next_blue[1];
                }
                else
                {
                    vector<int> next_blue = get_next_point(blue_x, blue_y, red_x, red_y, i);
                    blue_x_2 = next_blue[0];
                    blue_y_2 = next_blue[1];

                    vector<int> next_red = get_next_point(red_x, red_y, blue_x_2, blue_y_2, i);
                    red_x_2 = next_red[0];
                    red_y_2 = next_red[1];
                }
            }


            if (blue_x_2 != -1 && blue_y_2 != -1)
            {
                if (red_x_2 == -1 && red_y_2 == -1) // red만 탈출
                {
                    cout << (count + 1); // 최소 이동 종료
                    return 0;
                }
                else // 둘다 탈출 못함
                {
                    if (count + 1 < 10)
                    {
                        que.push({red_x_2, red_y_2, blue_x_2, blue_y_2, count+1});
                    }
                }
            }
        }
    }

    cout << -1;
}