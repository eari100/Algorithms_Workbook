#include<iostream>

using namespace std;

int n,m,d[30][30];
int answer = 0;

int main()
{
    cin>>n>>m;

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            cin>>d[i][j];
        }
    }

    for (int i=0;i<m;i++)
    {
        for (int j=i+1;j<m;j++)
        {
            for (int k=j+1;k<m;k++)
            {
                int score = 0;

                for (int l=0;l<n;l++)
                {
                    score += max(d[l][i], max(d[l][j], d[l][k]));
                }

                answer = max(answer, score);
            }
        }
    }

    cout<<answer;
}