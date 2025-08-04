#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1991 (트리 순회)
 * @classification: recursion
 * @문제 푼 날짜 (자력으로 풂?): 25.08.03 (O)
 **/
int tree_nodes[26][2], blank = -19;
string answers[3];

void bt(int node)
{
  if (node == blank) return;

  answers[0] += (char)(node+'A');
  bt(tree_nodes[node][0]);
  answers[1] += (char)(node+'A');
  bt(tree_nodes[node][1]);
  answers[2] += (char)(node+'A');
}

int main()
{
  int n;
  char p,l,r;
  cin>>n;

  while (n--)
  {
    cin>>p>>l>>r;
    tree_nodes[p-'A'][0] = (l-'A');
    tree_nodes[p-'A'][1] = (r-'A');
  }

  bt(0);

  for (string s : answers)
  {
    cout << s << '\n';
  }

  return 0;
}