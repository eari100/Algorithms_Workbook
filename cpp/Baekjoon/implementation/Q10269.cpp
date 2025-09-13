#include <iostream>

using namespace std;

/**
* @source: https://www.acmicpc.net/problem/10269 (Train Passengers)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.09.13 (O)
 **/
int capacity, passenger = 0, t, _left, entered, stay;
bool valid = true;

int main()
{
  cin >> capacity >> t;

  for(int i=0;i<t;i++)
  {
    cin >> _left >> entered >> stay;

    passenger -= _left;

    if(passenger < 0)
    {
      valid = false;
      break;
    }

    passenger += entered;

    if(passenger > capacity)
    {
      valid = false;
      break;
    }

    if(stay && (passenger < capacity))
    {
      valid = false;
      break;
    }

    if(i == t-1 && passenger)
    {
      valid = false;
    }
  }

  cout << (valid ? "possible" : "impossible");
}