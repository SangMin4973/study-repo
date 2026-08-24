def inorder(idx):
    global value

    if idx > n:
        return

    inorder(idx * 2)

    answer[idx] = value
    value += 1

    inorder(idx * 2 + 1)


T = int(input())

for t in range(T):
    n = int(input())

    answer = [0] * (n + 1)
    value = 1

    inorder(1)

    print(f"#{t+1} {answer[1]} {answer[n // 2]}")