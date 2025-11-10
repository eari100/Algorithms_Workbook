#include<iostream>

using namespace std;

int n, m, board[100][100], robots = 0;

/**
 * @source: https://www.acmicpc.net/problem/1736 (쓰레기 치우기)
 * @classification: greedy
 * @문제 푼 날짜 (자력솔?): 25.11.10 (O, 문제집 태그 봄)
 **/
int main()
{
    cin>>n>>m;

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            cin>>board[i][j];
        }
    }

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            if (board[i][j])
            {
                robots++;
                board[i][j] = 0;
                int width = j;

                for (int k=i;k<n;k++)
                {
                    for (int l=width;l<m;l++)
                    {
                        if (board[k][l])
                        {
                            board[k][l] = 0;
                            width = l;
                        }
                    }
                }
            }
        }
    }

    cout << robots;
}