#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/16724 (피리 부는 사나이)
 * @classification: union-find
 * @문제 푼 날짜 (자력으로 풂?): 25.11.22 (O)
 **/
int n, m, paths = 0;
int moves[4][2] = {
    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
};
char board[1000][1000];
int parents[1000][1000][2];
bool visited2[1000][1000];
string s;

vector<int> _find(int x, int y)
{
    if (parents[x][y][0] == x && parents[x][y][1] == y)
    {
        return {x, y};
    }

    vector<int> p = _find(parents[x][y][0], parents[x][y][1]);
    parents[x][y][0] = p[0];
    parents[x][y][1] = p[1];

    return p;
}

void _union(int x1, int y1, int x2, int y2)
{
    vector<int> p1 = _find(x1, y1);
    vector<int> p2 = _find(x2, y2);

    if (p1[0] == p2[0])
    {
        if (p1[1] < p2[1])
        {
            parents[p2[0]][p2[1]][0] = p1[0];
            parents[p2[0]][p2[1]][1] = p1[1];
        }
        else
        {
            parents[p1[0]][p1[1]][0] = p2[0];
            parents[p1[0]][p1[1]][1] = p2[1];
        }
    }
    else if (p1[0] < p2[0])
    {
        parents[p2[0]][p2[1]][0] = p1[0];
        parents[p2[0]][p2[1]][1] = p1[1];
    }
    else
    {
        parents[p1[0]][p1[1]][0] = p2[0];
        parents[p1[0]][p1[1]][1] = p2[1];
    }
}

int get_move_index(char c)
{
    if (c == 'U')
    {
        return 0;
    }
    else if (c == 'D')
    {
        return 1;
    }
    else if (c == 'L')
    {
        return 2;
    }
    else if (c == 'R')
    {
        return 3;
    }
}

int main()
{
    cin>>n>>m;
    getline(cin, s);

    for (int i=0;i<n;i++)
    {
        getline(cin, s);

        for(int j=0;j<m;j++)
        {
            board[i][j] = s[j];
            parents[i][j][0] = i;
            parents[i][j][1] = j;
        }
    }

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            int x1 = i, y1 = j;

            while (1)
            {
                int index = get_move_index(board[x1][y1]);
                int x2 = x1 + moves[index][0];
                int y2 = y1 + moves[index][1];

                if (x2 < 0 || x2 >= n || y2 < 0 || y2 >= m)
                {
                    break;
                }

                vector<int> p1 = _find(x1, y1);
                vector<int> p2 = _find(x2, y2);

                if (p1[0] == p2[0] && p1[1] == p2[1])
                {
                    break;
                }

                _union(x1, y1, x2, y2);
                x1 = x2, y1 = y2;
            }
        }
    }

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            vector<int> p = _find(i, j);

            if ( !visited2[p[0]][p[1]] )
            {
                ++paths;
                visited2[p[0]][p[1]] = true;
            }
        }
    }

    cout << paths;
}