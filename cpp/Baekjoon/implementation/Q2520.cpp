#include <iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2520 (팬케이크 사랑)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 25.01.29 (O)
 **/
int main()
{
    double gram1[] = { 0.5, 0.5, 0.25, 0.0625, 0.5625 };
    int gram2[] = { 1, 30, 25, 10 };

    int t, a, cake = 1000'000'000, topping = 0;
    cin >> t;

    while(t -- > 0)
    {
        for (int i=0;i<5;i++)
        {
            cin >> a;
            cake = min(cake, (int) (a / gram1[i]));
        }

        for (int i=0;i<4;i++)
        {
            cin >> a;
            topping += a / gram2[i];
        }

        cout << min(cake, topping) << endl;
        cake = 1000'000'000, topping = 0;
    }
}
