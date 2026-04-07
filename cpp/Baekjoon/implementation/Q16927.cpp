#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/16927 (배열 돌리기 2)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 26.04.07 (우,아래,좌,위 4분할 공식 실수, 길이 계산 실수 <- 급해도 공식을 잘 정리하고 옮기자)
 **/
int n,m,r,depth, moves[4][2] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
vector<vector<int>> matrix;
vector<vector<int>> matrix2;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin>>n>>m>>r;
    matrix.resize(n, vector<int> (m));
    matrix2.resize(n, vector<int> (m));
    depth=min(n,m)/2;

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            cin>>matrix[i][j];
        }
    }

    int h = n;
    int w = m;
    int idx1 = 0;
    int idx2 = 0;

    for (int i=0;i<depth;i++)
    {
        //cout<<h << ", " << w << endl;
        int total_len = (h * 2) + (w * 2) - 4;
        vector<int> tmp(total_len);
        int tmp_idx = 0;
        int rotate_size = r % total_len;

        // 오른
        for (int j=1;j<w;j++)
        {
            tmp[tmp_idx++] = matrix[idx1][idx2++];
        }

        // 아래
        for (int j=1;j<h;j++)
        {
            tmp[tmp_idx++] = matrix[idx1++][idx2];
        }

        // 왼
        for (int j=1;j<w;j++)
        {
            tmp[tmp_idx++] = matrix[idx1][idx2--];
        }

        // 위
        for (int j=1;j<h;j++)
        {
            tmp[tmp_idx++] = matrix[idx1--][idx2];
        }

        // idx 들은 0, 0 부터 시작
        int tmp_idx2 = rotate_size;
        matrix2[idx1][idx2] = tmp[tmp_idx2];

        tmp_idx2++;

        if (tmp_idx2 == total_len)
        {
            tmp_idx2 = 0;
        }
        idx2+=1;

        // 오른
        for (int j=1;j<w;j++)
        {
            matrix2[idx1][idx2] = tmp[tmp_idx2];
            idx2 += 1;

            tmp_idx2++;
            if (tmp_idx2 == total_len)
            {
                tmp_idx2 = 0;
            }
        }

        idx2 -= 1;
        idx1 += 1;

        // 아래
        for (int j=1;j<h;j++)
        {
            matrix2[idx1][idx2] = tmp[tmp_idx2];
            idx1 += 1;

            tmp_idx2++;
            if (tmp_idx2 == total_len)
            {
                tmp_idx2 = 0;
            }
        }

        idx1 -= 1;
        idx2 -= 1;

        // 왼
        for (int j=1;j<w;j++)
        {
            matrix2[idx1][idx2] = tmp[tmp_idx2];
            idx2 -= 1;

            tmp_idx2++;
            if (tmp_idx2 == total_len)
            {
                tmp_idx2 = 0;
            }
        }

        idx2 += 1;
        idx1 -= 1;

        // 위
        for (int j=1;j<h;j++)
        {
            matrix2[idx1][idx2] = tmp[tmp_idx2];
            idx1 -= 1;

            tmp_idx2++;
            if (tmp_idx2 == total_len)
            {
                tmp_idx2 = 0;
            }
        }

        idx1+=1;
        idx1+=1;
        idx2+=1;

        h-=2;
        w-=2;
    }

    for (int i=0;i<n;i++)
    {
        for (int j=0;j<m;j++)
        {
            cout<<matrix2[i][j]<<" ";
        }
        cout<<'\n';
    }
}