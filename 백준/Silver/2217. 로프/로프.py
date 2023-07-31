#2217 로프
import sys
input=sys.stdin.readline

n=int(input())
lst=[0 for i in range(10001)]
ans=[]
for i in range(n):
    lst[int(input())]+=1

for i in range(len(lst)):
    if lst[i]!=0:
        ans.append(i*n)
        n-=lst[i]

print(max(ans))