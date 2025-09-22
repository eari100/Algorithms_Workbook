#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1068 (트리)
 * @classification: dfs
 * @문제 푼 날짜 (자력으로 풂?): 25.09.22 (O)
 **/
int n, parent, remove_node, root_node;
vector<vector<int>> child;

int bt(int curr)
{
    if (curr == remove_node)
    {
        return 0;
    }

    if ( !child[curr].size() )
    {
        return 1;
    }

    if (child[curr].size() == 1 && child[curr][0] == remove_node)
    {
        return 1;
    }

    int child_cnt = 0;

    for (int i=0;i<child[curr].size();i++)
    {
        child_cnt += bt(child[curr][i]);
    }

    return child_cnt;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    child.resize(n);

    for (int i=0;i<n;i++)
    {
        cin>>parent;
        if (parent==-1)
        {
            root_node = i;
        }
        else
        {
            child[parent].push_back(i);
        }
    }

    cin >> remove_node;
    cout << bt(root_node);
}