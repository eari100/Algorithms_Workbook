#include <iostream>

using namespace std;

int main()
{
  long long kits[3] = {0, 0, 0}, _min, tmp;
  int day;
  cin >> day;

  while(day--)
  {
    _min = 1LL << 63 - 1;

    for(int i=0;i<3;i++)
    {
      cin >> tmp;
      kits[i] += tmp;

      _min = min(_min, kits[i]);
    }

    if(_min >= 30)
    {
      cout << _min << '\n';
      for(int i=0;i<3;i++)
      {
        kits[i] -= _min;
      }
    }
    else
    {
      cout << "NO" << '\n';
    }
  }
}