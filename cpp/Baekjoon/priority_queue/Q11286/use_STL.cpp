#include<iostream>
#include<vector>
#include<queue>

using namespace std;

struct Compare
{
  bool operator()(int a, int b)
  {
    if(abs(a) == abs(b))
    {
      return a > b;
    }

    return abs(a) > abs(b);
  }
};

int main()
{
  int n, x;
  cin >> n;

  priority_queue<int, vector<int>, Compare> pq;

  while(n--)
  {
    cin >> x;

    if(x == 0)
    {
      if(pq.empty())
      {
        cout << 0 << '\n';
      }
      else
      {
        cout << pq.top() << '\n';
        pq.pop();
      }
    }
    else
    {
      pq.push(x);
    }
  }
}