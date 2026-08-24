from collections import deque

T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    input()
    lst = list(map(int, input().split()))
    dq = deque(lst)
    num = 0
    
    while True:
        if num == 5:
            num = 0
        num += 1
        next = dq.popleft() - num
        
        if next <= 0:
            dq.append(0)
            break
        else:
            dq.append(next)
        

    answer = " ".join(map(str, dq))
    print(f"#{test_case} {answer}")

