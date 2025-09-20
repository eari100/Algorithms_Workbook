#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2461 (대표 선수)
 * @classification: two-pointer
 * @문제 푼 날짜 (자력으로 풂?): 25.09.20 (자력솔이긴 하지만 실수로 태그깜)
 **/
int n, m, cnt[1000], student, class_cnt = 0, min_gap, _str = 0, _end;
vector<vector<int>> vec;

struct comp
{
  bool operator() (vector<int> a, vector<int> b)
  {
    return a[0] < b[0];
  }
};

int main()
{
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);

  cin>>n>>m;

  for(int i=0;i<n;i++)
  {
    for(int j=0;j<m;j++)
    {
      cin>>student;
      vec.push_back({student, i});
    }
  }

  sort(vec.begin(), vec.end(), comp());

  for (int i=0;i<vec.size();i++)
  {
    cnt[vec[i][1]]++;
    _end = i;

    if (cnt[vec[i][1]] == 1)
    {
      ++class_cnt;

      if (class_cnt == n)
      {
        break;
      }
    }
  }

  min_gap = vec[_end][0] - vec[_str][0];

  while (_end < n*m)
  {
    if (cnt[vec[_str][1]] > 1)
    {
      cnt[vec[_str][1]]--;
      _str++;
    }
    else
    {
      _end++;
      if (_end == n*m)
      {
        break;
      }

      cnt[vec[_end][1]]++;
    }

    min_gap = min(min_gap, vec[_end][0] - vec[_str][0]);
  }

  cout << min_gap;
}