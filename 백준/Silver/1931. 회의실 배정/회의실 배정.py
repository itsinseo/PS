#1931 회의실 배정

import sys

input=sys.stdin.readline

n=int(input())


lst=[]

E=0
cnt=0

for i in range(n):
    s,e=map(int,input().split())
    lst.append([s,e])

lst.sort(key=lambda x:(x[1],x[0]))

for i in lst:
    if i[0]>=E:
        E=i[1]
        cnt+=1

print(cnt)