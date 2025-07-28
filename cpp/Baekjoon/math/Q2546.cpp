#include <iostream>
#include <vector>

using namespace std;

int main()
{
  long long t, n, m, tmp, answer;
  double average1, average2;
  cin>>t;
  vector<long long> v1, v2;

  while(t-- > 0)
  {
    cin >> n >> m;
    v1.clear();
    v2.clear();
    average1 = 0;
    average2 = 0;
    answer = 0;

    for(int i=0;i<n;i++)
    {
      cin >> tmp;
      average1 += tmp;
      v1.push_back(tmp);
    }
    average1 /= n;

    for(int i=0;i<m;i++)
    {
      cin >> tmp;
      average2 += tmp;
      v2.push_back(tmp);
    }
    average2 /= m;

    for(int i=0;i<n;i++)
    {
      if(average1 > v1[i] && average2 < v1[i])
      {
        ++answer;
      }
    }

    cout << answer << '\n';
  }
}