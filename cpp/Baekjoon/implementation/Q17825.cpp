#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/17825 (주사위 윷놀이)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 26.01.24 (O, 그냥 하드 코딩만 하면 되는데 고평가된 문제)
 **/
int dice[10];
int reward[32+1] =
{
    0, 2, 4, 6, 8,
    10, 12, 14, 16, 18,
    20, 22, 24, 26, 28,
    30, 32, 34, 36, 38,
    40,
    13, 16, 19,
    22, 24,
    28, 27, 26,
    25,
    30, 35,
    0
};

int graph[32][5+1] =
{
    {0, 1, 2, 3, 4, 5},
    {0, 2, 3, 4, 5, 6},
    {0, 3, 4, 5, 6, 7},
    {0, 4, 5, 6, 7, 8},
    {0, 5, 6, 7, 8, 9},

    {0, 21, 22, 23, 29, 30},

    {0, 7, 8, 9, 10, 11},
    {0, 8, 9, 10, 11, 12},
    {0, 9, 10, 11, 12, 13},
    {0, 10, 11, 12, 13, 14},

    {0, 24, 25, 29, 30, 31},

    {0, 12, 13, 14, 15, 16},
    {0, 13, 14, 15, 16, 17},
    {0, 14, 15, 16, 17, 18},
    {0, 15, 16, 17, 18, 19},

    {0, 26, 27, 28, 29, 30},

    {0, 17, 18, 19, 20, 32},
    {0, 18, 19, 20, 32, 32},
    {0, 19, 20, 32, 32, 32},
    {0, 20, 32, 32, 32, 32},
    {0, 32, 32, 32, 32, 32},

    {0, 22, 23, 29, 30, 31},
    {0, 23, 29, 30, 31, 20},
    {0, 29, 30, 31, 20, 32},

    {0, 25, 29, 30, 31, 20},
    {0, 29, 30, 31, 20, 32},

    {0, 27, 28, 29, 30, 31},
    {0, 28, 29, 30, 31, 20},
    {0, 29, 30, 31, 20, 32},

    {0, 30, 31, 20, 32, 32},
    {0, 31, 20, 32, 32, 32},
    {0, 20, 32, 32, 32, 32},
};
int piece[4];
int max_score = 0;

void bt(int turn, int score)
{
    if(turn == 10)
    {
        max_score = max(max_score, score);
        return;
    }

    for(int i=0;i<4;i++)
    {
        int dir = piece[i];

        if(dir == 32)
        {
            continue;
        }

        int next_dir = graph[dir][dice[turn]];

        bool can_move = true;
        if(next_dir < 32)
        {
            for(int j=0;j<4;j++)
            {
                if(i == j)
                {
                    continue;
                }

                if(next_dir == piece[j])
                {
                    can_move = false;
                    break;
                }
            }
        }

        if(can_move)
        {
            piece[i] = next_dir;
            bt(turn+1, score + reward[piece[i]]);
            piece[i] = dir;
        }
    }
}

int main()
{
    for(int i=0;i<10;i++)
    {
        cin>>dice[i];
    }

    bt(0, 0);

    cout<<max_score;
}