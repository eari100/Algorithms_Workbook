#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2473 (세 용액)
 * @classification: two-pointer (three-pointer)
 * @문제 푼 날짜 (자력으로 풂?): 25.08.07 (X)
 **/
int main()
{
    int n;
    cin >> n;
    vector<long long> v(n);
    int answer[3] = {1'000'000'001, 1'000'000'001, 1'000'000'001};
    long long min_abs = 3'000'000'003;

    for (int i = 0; i < n; i++)
        cin >> v[i];

    sort(v.begin(), v.end());

    for (int i=0;i<n;i++)
    {
        int s = i+1, e = n-1;

        while (s < e)
        {
            long long sum = v[i] + v[s] + v[e];

            if (abs(sum) < min_abs)
            {
                min_abs = abs(sum);
                answer[0] = v[i];
                answer[1] = v[s];
                answer[2] = v[e];
            }

            if (sum == 0)
            {
                for (int a : answer)
                    cout << a << ' ';

                return 0;
            }

            if (sum > 0)
            {
                --e;
            }
            else
            {
                ++s;
            }
        }
    }

    for (int i : answer)
        cout << i << ' ';
}
