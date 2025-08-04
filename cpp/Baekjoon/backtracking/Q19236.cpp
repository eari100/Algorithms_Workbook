#include <iostream>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/19236 (청소년 상어)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.08.04 (O)
 **/

// void _print(vector<vector<vector<int>>> v)
// {
//
//     for (int i=0;i<4;i++)
//     {
//         for (int j=0;j<4;j++)
//         {
//             cout << v[i][j][0] << ' ';
//         }
//         cout << endl;
//     }
//     cout << "--------------" << endl;
//     for (int i=0;i<4;i++)
//     {
//         for (int j=0;j<4;j++)
//         {
//             cout << v[i][j][1] << ' ';
//         }
//         cout << endl;
//     }
//
//     cout << "=======================" << endl;
// }

int _max = 0, shark = -1, blank = -2;
// 상 ~ 반시계
int moves[8][2] =
{
    {-1,0},{-1,-1},{0,-1},{1,-1},
    {1,0}, {1, 1}, {0, 1}, {-1, 1}
};

void move_fishes(vector<vector<vector<int>>>& board, vector<vector<int>>& fishes_dir)
{
    for (int num=0;num<16;num++)
    {
        vector<int> fish_dir = fishes_dir[num];
        if (fish_dir[0] == -1) // 이미 먹힘
        {
            continue;
        }

        int move_index = board[fish_dir[0]][fish_dir[1]][1];
        int rotate_cnt = 8;

        while (rotate_cnt--)
        {
            vector<int> next_dir = {fish_dir[0]+moves[move_index][0], fish_dir[1]+moves[move_index][1]};

            if (next_dir[0] >= 0 && next_dir[0] < 4 && next_dir[1] >= 0 && next_dir[1] < 4 && board[next_dir[0]][next_dir[1]][0] != shark)
            {
                board[fish_dir[0]][fish_dir[1]][1] = move_index;
                bool is_next_blank = board[next_dir[0]][next_dir[1]][0] == blank;
                // dir 반영
                if (is_next_blank)
                {
                    fishes_dir[num] = {next_dir[0], next_dir[1]};
                }
                else
                {
                    int next_num = board[next_dir[0]][next_dir[1]][0];
                    // dir swap
                    vector<int> tmp = fishes_dir[num];
                    fishes_dir[num] = fishes_dir[next_num];
                    fishes_dir[next_num] = tmp;
                }

                // board 반영
                vector<int> tmp = board[fish_dir[0]][fish_dir[1]];
                board[fish_dir[0]][fish_dir[1]] = board[next_dir[0]][next_dir[1]];
                board[next_dir[0]][next_dir[1]] = tmp;

                break;
            }

            ++move_index;
            move_index %= 8;
        }

        // cout << "num: " << num << endl;
        // _print(board);
    }
}

void bt(vector<vector<vector<int>>> board, int score, vector<int> shark_dir, vector<vector<int>> fishes_dir)
{
    // todo: remove
    //_print(board);

    // 물고기 움직이기
    move_fishes(board, fishes_dir);

    // 상어 움직이기
    bool is_move_shark = false;
    int dist = 0;

    while (dist++ < 4)
    {
        int s_move_index = board[shark_dir[0]][shark_dir[1]][1];
        vector<int> next_shark_dir =
        {
            shark_dir[0] + (moves[s_move_index][0] * dist),
            shark_dir[1] + (moves[s_move_index][1] * dist),
        };

        // 범위 넘어갈 경우 종료
        if (next_shark_dir[0] < 0 || next_shark_dir[0] >= 4 || next_shark_dir[1] < 0 || next_shark_dir[1] >= 4) break;
        // 빈칸
        if (board[next_shark_dir[0]][next_shark_dir[1]][0] == blank) continue;

        is_move_shark = true;

        vector<vector<vector<int>>> next_board = board;
        vector<vector<int>> next_fishes_dir = fishes_dir;
        // 물고기 먹음 처리
        int eat_num = next_board[next_shark_dir[0]][next_shark_dir[1]][0];
        next_board[next_shark_dir[0]][next_shark_dir[1]][0] = blank;
        next_fishes_dir[eat_num] = {-1, -1};

        // 상어 있던 자리 무방향 처리
        next_board[shark_dir[0]][shark_dir[1]][1] = -1;

        // 상어 board, share_dir 업데이트 (이미 함), num만 변경, 방향은 그대로 둠
        int tmp = next_board[shark_dir[0]][shark_dir[1]][0];
        next_board[shark_dir[0]][shark_dir[1]][0] = next_board[next_shark_dir[0]][next_shark_dir[1]][0];
        next_board[next_shark_dir[0]][next_shark_dir[1]][0] = tmp;

        bt(next_board, score + (board[next_shark_dir[0]][next_shark_dir[1]][0] + 1), next_shark_dir, next_fishes_dir);
    }

    if ( !is_move_shark )
    {
        _max = max(_max, score);
    }
}

int main()
{
    vector<vector<vector<int>>> board(4, vector<vector<int>>(4, vector<int>(2))); // 상어: -1, 빈칸: -2;
    vector<vector<int>> fishes_dir(16, vector<int>(2));
    vector<int> shark_dir = {0, 0};

    for(int i=0;i<4;i++)
    {
        for(int j=0;j<4;j++)
        {
            int num;
            cin>>num;
            num--;
            cin>>board[i][j][1];

            board[i][j][0] = num;
            board[i][j][1]--;

            fishes_dir[num] = {i, j};
        }
    }

    int first_fish_num = board[0][0][0];
    board[0][0][0] = shark;
    fishes_dir[first_fish_num] = {-1, -1};

    bt(board, first_fish_num + 1, shark_dir, fishes_dir);

    cout << _max;
}