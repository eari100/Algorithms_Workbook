#include<iostream>
#include<queue>
#include<map>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/7662 (이중 우선순위 큐)
 * @classification: priority queue, map
 * @문제 푼 날짜 (자력으로 풂?): 25.07.31 (X)
 * @반례: https://www.acmicpc.net/board/view/127182
 **/
int main()
{
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  int t;
  cin>>t;
  while(t--)
  {
    int n;
    cin>>n;

    priority_queue<int> max_heap;
    priority_queue<int, vector<int>, greater<int>> min_heap;
    map<int, int> _map;

    while (n--)
    {
      char q;
      int num;
      cin>>q>>num;

      if (q == 'I')
      {
        max_heap.push(num);
        min_heap.push(num);
        _map[num]++;
      }
      else
      {
        if (num > 0 && max_heap.size() > 0)
        {
          _map[max_heap.top()]--;
          max_heap.pop();
        }
        else if (num < 0 && min_heap.size() > 0)
        {
          _map[min_heap.top()]--;
          min_heap.pop();
        }

        while (max_heap.size() > 0 && _map[max_heap.top()] == 0)
        {
          max_heap.pop();
        }

        while (min_heap.size() > 0 && _map[min_heap.top()] == 0)
        {
          min_heap.pop();
        }
      }
    }

    if (max_heap.size() == 0 || min_heap.size() == 0)
    {
      cout << "EMPTY";
    }
    else
    {
      cout << max_heap.top() << ' ' << min_heap.top();
    }

    cout << '\n';
  }
}