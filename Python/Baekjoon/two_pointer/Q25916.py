# @source: https://www.acmicpc.net/problem/25916 (싫은데요)
# @classification: two pointer
# @문제 푼 날짜 (자력으로 풂?): 25.09.16 (O, 깔끔하게 구현하도록 구상할껄)
n, m  = map(int, input().split())
_list = list(map(int, input().split()))
l, r = 0, -1
_inf = 1_000_000_001
remain, min_remain = m, _inf

while r < n:
    if r+1 < n:
        if _list[r+1] > m: # 장애물 만났을 경우
            r+=2
            while r < n:
                if _list[r] <= m:
                    l = r
                    remain = m - _list[r]
                    min_remain = min(min_remain, remain)
                    break
                r+=1

        elif _list[r+1] <= remain:
            r+=1
            remain -= _list[r]
            min_remain = min(min_remain, remain)

        else:
            remain += _list[l]
            l += 1
    else:
        break

if min_remain == _inf:
    print(0)
else:
    print(m - min_remain)
