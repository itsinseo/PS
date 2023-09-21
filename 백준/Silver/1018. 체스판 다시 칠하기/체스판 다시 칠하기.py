#1018 체스판 다시 칠하기

import sys

input=sys.stdin.readline

m,n=map(int,input().split())

lst=[input().rstrip() for i in range(m)]

pattern=["W","B"]

ans=[]

for i in range(0,m-7):
    for j in range(0,n-7):
        cnt=0
        num=0
        for k in range(i,i+8):
            for l in range(j,j+8):
                if lst[k][l]!=pattern[num%2]:
                    cnt+=1
                num+=1
            num+=1
        ans.append(min(cnt,64-cnt))

print(min(ans))