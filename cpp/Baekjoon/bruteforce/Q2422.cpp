#include <iostream>
#include <set>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2422 (한윤정이 이탈리아에 가서 아이스크림을 사먹는데)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.06.13 (O)
 **/
set<int> _set;
set<int> excludes[200+1];
int n, m, answer = 0;

void bt(int start)
{
  if(_set.size() == 3)
  {
    ++answer;
    return;
  }

  for(int next=start;next<=n;next++)
  {
    bool flag = false;
    for (set<int>::iterator it = _set.begin();it != _set.end();++it)
    {
      for (set<int>::iterator it2 = excludes[*it].begin();it2 != excludes[*it].end();++it2)
      {
        if (*it2 == next)
        {
          flag = true;
          break;
        }
      }
    }

    if (!flag)
    {
      _set.insert(next);
      bt(next+1);
      _set.erase(next);
    }
  }
}

int main()
{
  cin >> n >> m;

  for(int i=0;i<m;i++)
  {
    int a, b;
    cin >> a >> b;

    excludes[a].insert(b);
    excludes[b].insert(a);
  }

  bt(1);

  cout << answer;
}