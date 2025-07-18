#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/5462 (POI)
 * @classification: sort
 * @문제 푼 날짜 (자력으로 풂?): 25.07.06 (O)
 **/
int main()
{
  int person, question, p;

  cin >> person >> question >> p;

  vector<int> q(question, 0);
  vector<vector<int>> cal(person, vector<int>(question, 0)); // 점수, 갯수, 번호
  vector<vector<int>> leaderboard(person, vector<int>(question, 0));

  for(int i=0;i<person;i++)
  {
    for(int j=0;j<question;j++)
    {
      cin >> leaderboard[i][j];

      if(leaderboard[i][j] == 0)
      {
        q[j]++;
      }
      else
      {
        cal[i][1]++; // 갯수
      }
    }

    cal[i][2] = i+1;// 번호
  }

  for(int i=0;i<person;i++)
  {
    for(int j=0;j<question;j++)
    {
      if(leaderboard[i][j] == 1)
      {
        cal[i][0] += q[j];
      }
    }
  }

  sort(cal.begin(), cal.end(), [](vector<int>& a, vector<int>& b) {
    if(a[0] == b[0])
    {
      if(a[1] == b[1])
      {
        return a[2] < b[2];
      }
      else
      {
        return a[1] > b[1];
      }
    }
    else
    {
      return a[0] > b[0];
    }
  });

  for(int i=0;i<person;i++)
  {
    if(cal[i][2] == p)
    {
      cout << cal[i][0] << " " << i+1;
      return 0;
    }
  }
}