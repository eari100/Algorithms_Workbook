#include <iostream>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/5639 (이진 검색 트리)
 * @classification: recursion
 * @문제 푼 날짜 (자력으로 풂?): 25.12.12 (X)
 **/
int x;
vector<int> nodes;

struct my_node
{
    int x;
    my_node* left;
    my_node* right;
};

my_node* root = new my_node();

void solve(my_node* curr, int str, int end)
{
    curr->x = nodes[str];
    int boundary = 0;

    for (int i=str+1;i<=end;i++)
    {
        if (nodes[i] > curr->x)
        {
            break;
        }

        ++boundary;
    }

    if (str+1 <= str+boundary)
    {
        curr->left = new my_node();
        solve(curr->left, str+1, str+boundary);
    }

    if (str+boundary+1 <= end)
    {
        curr->right = new my_node();
        solve(curr->right, str+boundary+1, end);
    }

    cout<<curr->x<<'\n';
}

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    while (cin>>x)
    {
        nodes.push_back(x);
    }

    solve(root, 0, nodes.size()-1);
}