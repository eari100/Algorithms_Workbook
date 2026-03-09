#include<iostream>
#include<vector>

using namespace std;

int n, m, x;
vector<vector<int>> v;
vector<int> bucket_size;
bool possible[1001][1001];

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin>>n>>m;
    bucket_size.resize(m+1);
    v.resize(m+1);

    for(int i=1;i<=m;i++)
    {
        cin>>bucket_size[i];
    }

    for(int i=0;i<2;i++)
    {
        for(int j=1;j<=n;j++)
        {
            while(1)
            {
                cin>>x;
                if(x == -1)
                {
                    break;
                }

                v[x].push_back(j);
            }
        }

        for(int j=1;j<=m;j++)
        {
            if(v[j].size() <= bucket_size[j])
            {
                for(int k=0;k<v[j].size();k++)
                {
                    possible[v[j][k]][j] = true;
                }
            }
        }
    }

    for(int i=1;i<=n;i++)
    {
        bool f = false;
        for(int j=1;j<=m;j++)
        {
            if(possible[i][j])
            {
                f = true;
                cout << j << " ";
            }
        }

        if(!f)
        {
            cout<<"망했어요";
        }

        cout<<'\n';
    }
}