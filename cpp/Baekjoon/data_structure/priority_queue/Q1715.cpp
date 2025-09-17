#include <iostream>
#include <queue>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/1715 (카드 정렬하기)
 * @classification: priority queue
 * @문제 푼 날짜 (자력으로 풂?): 25.09.17 (O)
 **/
struct min_heap
{
  bool operator()(int a, int b)
  {
    return a > b;
  }
};

int t, cnt;
long long card_size = 0, sum;
priority_queue<int, vector<int>, min_heap> pq;

int main()
{
  cin >> t;
  while(t--)
  {
    cin>>cnt;
    pq.push(cnt);
  }

  while ( pq.size() > 1 )
  {
    long long a = pq.top();
    pq.pop();

    long long b = pq.top();
    pq.pop();

    sum = a + b;
    card_size += sum;
    pq.push(sum);
  }

  cout << card_size;
}