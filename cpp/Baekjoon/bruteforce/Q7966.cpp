#include <iostream>
#include <vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/7696 (반복하지 않는 수)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.05.21 (O)
 **/
int main()
{
  int n;
  long long curr = 1;
  vector<long long> nums;

  while (nums.size() < 1'000'000)
  {
    long long num = curr, count[10] = {0};
    bool skip = false;

    while(num > 0)
    {
      if(count[num % 10])
      {
        skip = true;
        break;
      }
      count[num % 10]++;
      num /= 10;
    }

    if ( !skip )
      nums.push_back(curr);

    curr++;
  }

  while(true)
  {
    cin >> n;
    if(n == 0) break;

    cout << nums[n-1] << '\n';
  }
}