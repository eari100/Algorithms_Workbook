#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/16938 (캠프 준비)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.07.31 (O)
 **/
int n, l, r, x, num, answer = 0;
vector<int> nums;

void solve(int index, int sum, int _min, int _max, int count)
{
  if(index == n) return;

  solve(index+1, sum, _min, _max, count);

  int _min2 = min(_min, nums[index]);
  int _max2 = max(_max, nums[index]);

  if(count+1 >= 2 && sum+nums[index] >= l && sum+nums[index] <= r && (_max2 - _min2 >= x))
  {
    answer++;
  }

  solve(index+1, sum+nums[index], _min2, _max2, count+1);
}

int main()
{
  cin>>n>>l>>r>>x;

  for(int i=0;i<n;i++)
  {
    cin >> num;
    nums.push_back(num);
  }

  solve(0, 0, 1'000'001, 0, 0);

  cout << answer;
}