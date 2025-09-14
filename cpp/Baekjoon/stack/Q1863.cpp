#include<iostream>
#include<stack>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1863 (스카이라인 쉬운거)
 * @classification: stack
 * @문제 푼 날짜 (자력으로 풂?): 25.09.14 (O)
 **/
int n, x, y, answer = 0;
stack<int> stk;

int main()
{
  cin >> n;

  for(int i=0;i<n;i++)
  {
    cin >> x >> y;

    if(y == 0)
    {
      while(!stk.empty()) // 비움
      {
        stk.pop();
      }
    }
    else
    {
      if(stk.empty())
      {
        ++answer;
        stk.push(y);
      }
      else
      {
        bool flag = false;

        while(!stk.empty())
        {
          if(stk.top() == y)
          {
            flag = true;
            break;
          }
          else if(stk.top() < y)
          {
            flag = true;
            ++answer;
            stk.push(y);
            break;
          }
          else
          {
            stk.pop();
          }
        }

        if (!flag)
        {
          stk.push(y);
          ++answer;
        }
      }
    }
  }

  cout << answer;
}