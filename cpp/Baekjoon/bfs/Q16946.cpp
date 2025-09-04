#include <iostream>
#include <vector>
#include <queue>
#include <set>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/16946 (벽 부수고 이동하기 4)
 * @classification: bfs, data structure
 * @문제 푼 날짜 (자력으로 풂?): 25.09.04 (O)
 **/
int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    int n,m;
    cin>>n>>m;

    int board[n][m];
    int cache[n][m]; // db 번호 저장
    int moves[4][2] =
    {
        {-1,0},{0,1},{1,0},{0,-1}
    };

    vector<int> db; // 갯수 저장

    string s;
    for (int i=0;i<n;i++)
    {
        cin>>s;
        for (int j=0;j<m;j++)
        {
            board[i][j] = (s[j] == '1') ? 1 : 0;
            cache[i][j] = -1; // 초기화
        }
    }

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            if (board[i][j] == 0 && cache[i][j] == -1)
            {
                int count = 1;
                queue<vector<int>> q;
                q.push({i ,j});
                cache[i][j] = db.size();

                while (!q.empty())
                {
                    vector<int> curr = q.front();
                    q.pop();

                    for (int k=0;k<4;k++)
                    {
                        int x = curr[0] + moves[k][0];
                        int y = curr[1] + moves[k][1];

                        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] == 1 || cache[x][y] != -1) continue;

                        count++;
                        q.push({x,y});
                        cache[x][y] = db.size();
                    }
                }

                db.push_back(count);
            }
        }
    }

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            if (board[i][j] == 0)
            {
                cout << 0;
            }
            else
            {
                int count = 1;
                set<int> _set;
                for (int k=0;k<4;k++)
                {
                    int x = i + moves[k][0];
                    int y = j + moves[k][1];
                    int prev_set = _set.size();

                    if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] == 1) continue;
                    _set.insert(cache[x][y]);
                    if (prev_set == _set.size()) continue;

                    count += db[cache[x][y]];
                }

                cout << count % 10;
            }
        }

        cout << '\n';
    }
}