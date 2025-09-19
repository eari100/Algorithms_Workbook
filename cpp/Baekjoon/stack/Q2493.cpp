#include <iostream>
#include <stack>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2493 (탑)
 * @classification: stack
 * @문제 푼 날짜 (자력으로 풂?): 25.09.19 (O)
 **/
int main()
{
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  int n, h;
  cin>>n;

  stack<vector<int>> stk;

  for(int i=0;i<n;i++)
  {
    cin>>h;

    while(stk.size() > 0)
    {
      vector<int> _top = stk.top();

      if(_top[0] < h)
      {
        stk.pop();
      }
      else
      {
        break;
      }
    }

    if(stk.size() == 0)
    {
      cout << "0 ";
    }
    else
    {
      cout << stk.top()[1] + 1 << " ";
    }

    stk.push({h, i});
  }
}
