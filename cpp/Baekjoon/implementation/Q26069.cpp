#include <iostream>
#include <set>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/26069 (붙임성 좋은 총총이)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.05.19 (O)
 **/
int main()
{
  int n;
  cin>>n;

  set<string> _set;
  _set.insert("ChongChong");

  while(n--)
  {
    string a, b;
    cin >> a >> b;

    set<string>::iterator it_a = _set.find(a);
    set<string>::iterator it_b = _set.find(b);

    if(it_a != _set.end() || it_b != _set.end())
    {
        _set.insert(a);
        _set.insert(b);
    }
  }

  cout << _set.size();
}