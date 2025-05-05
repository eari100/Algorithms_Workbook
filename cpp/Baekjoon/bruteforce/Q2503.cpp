#include<iostream>
#include<vector>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/2503 (숫자 야구)
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 25.05.06 (X)
 **/
int main()
{
    int n;
    cin>>n;

    vector<vector<vector<bool>>> matched(10, vector<vector<bool>>(10, vector<bool>(10, false)));
    int count = 0;

    for (int i=1;i<=9;i++) {
        for (int j=1;j<=9;j++) {
            for (int k=1;k<=9;k++) {
                if (i != j && i != k && j != k) {
                    matched[i][j][k]=true;
                    ++count;
                }
            }
        }
    }

    while (n--)
    {
        int num, s, b;
        cin>>num>>s>>b;
        int num_arr[3];
        int index = 2;

        while (num > 0) {
            num_arr[index--] = num % 10;
            num /= 10;
        }

        for (int i=1;i<=9;i++) {
            for (int j=1;j<=9;j++) {
                for (int k=1;k<=9;k++) {
                    if ( !matched[i][j][k] ) continue;

                    int s2 = 0, b2 = 0;

                    if (i == num_arr[0]) {
                        s2++;
                    } else if (i == num_arr[1] || i == num_arr[2]) {
                        b2++;
                    }

                    if (j == num_arr[1]) {
                        s2++;
                    } else if (j == num_arr[0] || j == num_arr[2]) {
                        b2++;
                    }

                    if (k == num_arr[2]) {
                        s2++;
                    } else if (k == num_arr[0] || k == num_arr[1]) {
                        b2++;
                    }

                    if (s != s2 || b != b2) {
                        matched[i][j][k]=false;
                        --count;
                    }
                }
            }
        }
    }

    cout << count << endl;
}