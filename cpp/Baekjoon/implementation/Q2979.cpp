#include <iostream>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2979 (트럭 주차)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.01.21 (O)
 * @reference: https://www.acmicpc.net/source/452241 (기가 막힌 구현)
 **/
int main()
{
  int a, b, c, cost, logs[3][2], car_cnt = 0, time = 1;
  bool finished[3] = {false, false, false};
  cin >> a >> b >> c;

  for (int i = 0; i < 6; i++)
  {
    int t;
    cin >> t;
    logs[i/2][i%2] = t;
  }

  while(!finished[0] || !finished[1] || !finished[2])
  {
    if(car_cnt == 1)
    {
      cost += a;
    }
    else if(car_cnt == 2)
    {
      cost += 2 * b;
    }
    else if(car_cnt == 3)
    {
      cost += 3 * c;
    }

    if( !finished[0] )
    {
      if(time == logs[0][0])
      {
        ++car_cnt;
      }
      else if(time == logs[0][1])
      {
        --car_cnt;
        finished[0] = true;
      }
    }

    if( !finished[1] )
    {
      if(time == logs[1][0])
      {
        ++car_cnt;
      }
      else if(time == logs[1][1])
      {
        --car_cnt;
        finished[1] = true;
      }
    }

    if( !finished[2] )
    {
      if(time == logs[2][0])
      {
        ++car_cnt;
      }
      else if(time == logs[2][1])
      {
        --car_cnt;
        finished[2] = true;
      }
    }

    time++;
  }

  cout << cost;
}