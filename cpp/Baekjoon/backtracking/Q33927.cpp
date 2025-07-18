#include <iostream>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/33927 (나이트 오브 나이츠)
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 25.07.14 (X)
 **/
int N, scores[4][4], max_score = 0, curr_score;

bool visited[4][4];

bool canigo(int x, int y)
{
    int knight_moves[4][2] =
    {
        {1, -2}, {1, 2},
        {2, -1}, {2, 1}
    };

    for (int i=0;i<N;i++)
    {
        for (int j=0;j<N;j++)
        {
            if (visited[i][j])
            {
                for (int k=0;k<4;k++)
                {
                    int x2 = i+knight_moves[k][0];
                    int y2 = j+knight_moves[k][1];

                    if (x2 == x && y2 == y)
                    {
                        return false;
                    }
                }
            }
        }
    }

    return true;
}

vector<int> next_xy(int x, int y)
{
    y++;

    if (y == N)
    {
        x++;
        y = 0;
    }

    return {x, y};
}

void bt(int x, int y)
{
    if (x >= N || y >= N)
    {
        return;
    }

    vector<int> next = next_xy(x, y);
    bt(next[0], next[1]);


    if (visited[x][y] || !canigo(x, y))
    {
        return;
    }

    curr_score += scores[x][y];
    visited[x][y] = true;
    max_score = max(max_score, curr_score);
    bt(next[0], next[1]);
    visited[x][y] = false;
    curr_score -= scores[x][y];
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> scores[i][j];
            visited[i][j] = false;
        }
    }

    bt(0, 0);
    cout << max_score << endl;

    return 0;
}