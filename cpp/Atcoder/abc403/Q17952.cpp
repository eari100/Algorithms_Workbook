#include<iostream>
#include<stack>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/17952 (과제는 끝나지 않아!)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.06.11 (O)
 **/
stack<vector<int>> stk;
int total_score = 0;

void process(vector<int> task)
{
  // remain_time
  task[1]--;
  if(task[1] == 0)
  {
    total_score += task[0];
  }
  else
  {
    stk.push(task);
  }
}

int main()
{
  int t;
  cin >> t;

  while(t--)
  {
    int type;
    cin >> type;

    if(type)
    {
      int score, remain_time;
      cin >> score >> remain_time;

      process(vector<int>{score, remain_time});
    }
    else
    {
      if(stk.empty()) continue;

      vector<int> top = stk.top();
      stk.pop();

      process(top);
    }
  }

  cout << total_score;
}