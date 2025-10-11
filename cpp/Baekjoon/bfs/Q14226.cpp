#include<iostream>
#include<queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/14226 (이모티콘)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.10.11 (O)
 **/
int s;
queue<vector<int>> q;
bool check[2000+1][2000+1];

int main()
{
    cin>>s;

    q.push({1, 0, 0});

    while (q.size())
    {
        vector<int> front = q.front();

        if (front[0] == s)
        {
            cout<<front[2];
            break;
        }
        q.pop();

        // 복사
        if (front[0] < 2000+1 && front[0] != front[1] && !check[front[0]][front[0]])
        {
            check[front[0]][front[0]] = true;
            q.push({front[0], front[0], front[2]+1});
        }

        // 붙여넣기
        if (front[0]+front[1] < 2000+1 && front[1] < 2000+1 && !check[front[0]+front[1]][front[1]])
        {
            check[front[0]+front[1]][front[1]] = true;
            q.push({front[0]+front[1], front[1], front[2]+1});
        }

        // 삭제
        if (front[0] - 1 >= 0 && !check[front[0]-1][front[1]])
        {
            check[front[0]-1][front[1]] = true;
            q.push({front[0]-1, front[1], front[2]+1});
        }
    }
}