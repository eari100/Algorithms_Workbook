#include <iostream>
#include <queue>

using namespace std;

int main()
{
  int n;
  cin >> n;

  queue<int> que;

  for(int i=1;i<=n;i++)
  {
    que.push(i);
  }

  while(que.size() > 1)
  {
    cout << que.front() << " ";
    que.pop();

    int f = que.front();
    que.pop();
    que.push(f);
  }

  cout << que.front();
}