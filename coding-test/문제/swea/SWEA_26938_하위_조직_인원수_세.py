
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    E, N = map(int, input().split())
    lst = list(map(int, input().split()))
    table = {}
    for i in range(0, E*2, 2):
        if i%2==0:
            if lst[i] in table:
                table[lst[i]].append(lst[i+1])

            else:
                table[lst[i]] = [lst[i+1]]

    answer = []

    q = [N]

    while q:
        p = q.pop()

        if p in table:
            q += table[p]
            answer += table[p]


    print(f"#{test_case} {len(answer) + 1}")       




