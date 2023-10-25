#2606 바이러스

import sys
input=sys.stdin.readline
#input=open("0.txt","r").readline

n=int(input())
m=int(input())

graph=[[] for i in range(n+1)]
for i in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
    
def BFS():
    virus=[0]*(n+1)
    stack=[1]
    while stack:
        r=stack.pop()
        if virus[r]==0:
            virus[r]=1
        for i in graph[r]:
            if virus[i]==0:
                stack.append(i)
                
    return sum(virus)-1
            
print(BFS())