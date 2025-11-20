    #include<iostream>
    #include<algorithm>
    #include<vector>

    using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/23561 (Young한 에너지는 부족하다)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.11.20 (O)
 **/
    int main()
    {
        ios_base::sync_with_stdio(false);
        cout.tie(NULL);
        cin.tie(NULL);

        int n;
        cin>>n;
        vector<long long> arr(n*3);

        for(int i=0;i<n*3;i++)
        {
            cin>>arr[i];
        }

        sort(arr.begin(), arr.end());

        cout<<(arr[2*n-1] - arr[n]);
    }