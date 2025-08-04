#include <iostream>
#include <stack>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/9935 (문자열 폭발)
 * @classification: stack
 * @문제 푼 날짜 (자력으로 풂?): 25.08.05 (O)
 **/
int main()
{
  string s, bomb, FRULA = "FRULA";
  cin >> s >> bomb;
  stack<char> stk;

  for (int i=0;i<s.size();i++)
  {
    if (s[i] == bomb[bomb.size()-1])
    {
      stack<char> tmp;
      tmp.push(s[i]);

      for (int j=bomb.size()-2;j>=0;j--)
      {
        if (stk.empty())
        {
          break;
        }

        if (stk.top() == bomb[j])
        {
          tmp.push(bomb[j]);
          stk.pop();
        }
      }

      if (tmp.size() != bomb.size())
      {
        while ( !tmp.empty() )
        {
          stk.push(tmp.top());
          tmp.pop();
        }
      }
    }
    else
    {
      stk.push(s[i]);
    }
  }

  if (stk.empty())
  {
    cout << FRULA;
  }
  else
  {
    string answer = "";
    while( !stk.empty() )
    {
      answer += stk.top();
      stk.pop();
    }

    for (int i=0;i<answer.size()/2;i++)
    {
      char tmp = answer[i];
      answer[i] = answer[answer.size()-1-i];
      answer[answer.size()-1-i] = tmp;
    }
    cout << answer;
  }
}