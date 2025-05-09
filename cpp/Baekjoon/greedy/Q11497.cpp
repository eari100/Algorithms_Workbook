#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/11497 (통나무 건너뛰기)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.05.09 (O)
 **/
int main()
{
	int t;
	cin >> t;
    while(t--)
    {
      int n;
      cin>>n;

      vector<int> v(n);

      	for(int i=0;i<n;i++)
		{
      		cin >> v[i];
    	}

    	sort(v.begin(), v.end());

        int _max = max(v[1] - v[0], v[v.size()-1] - v[v.size()-2]);

        for(int i=2;i<n;i+=2)
        {
          _max = max(_max, v[i] - v[i-2]);
        }

        int i = n % 2 == 0 ? v.size()-1 - 2 : v.size()-2 - 2;
        for(int j=i;j>=0;j-=2)
        {
          _max = max(_max, v[j+2] - v[j]);
        }

        cout << _max << '\n';
    }
}