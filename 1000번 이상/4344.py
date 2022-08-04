
N = int(input())

for i in range(N):
    M = list(map(int, input().split()))
    avg = sum(M[1:])/M[0]

    cnt = 0
    for score in M[1:]:
        if score > avg:
            cnt += 1
    result = ("{0:.3f}".format(cnt / M[0] * 100))
    print(result+"%")
