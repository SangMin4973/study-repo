T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    _, lst = map(str, input().split())

    answer = ""

    for s in lst:
        hex = bin(int(s, 16))[2:]

        answer += '0'*(4-len(hex)) + hex

    print(f"#{test_case} {answer}")