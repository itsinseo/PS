#11866 요세푸스 문제0, 수정

n, k = map(int, input().split())
result = []
lst = []
idx = 0

for i in range(1, n+1):
    lst.append(i)

for _ in range(n):
    idx += k - 1
    if idx >= len(lst):
        idx = idx % len(lst)
    result.append(str(lst.pop(idx)))

print(f'<{", ".join(result)[:]}>')