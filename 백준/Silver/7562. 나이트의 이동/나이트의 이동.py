#7562 나이트의 이동
import sys
from collections import deque
input=sys.stdin.readline

def knight():
    dx=[1,2,2,1,-1,-2,-2,-1]
    dy=[2,1,-1,-2,-2,-1,1,2]
    
    while queue:
        s=queue.popleft()
        x0,y0=s[0],s[1]
        
        for i in range(8):
            x,y=x0+dx[i],y0+dy[i]
            if 0<=x<l and 0<=y<l and board[x][y]==0:
                queue.append([x,y])
                board[x][y]=board[x0][y0]+1
            if x==goal[0] and y==goal[1]:
                return

t=int(input())
for _ in range(t):
    l=int(input())
    now=list(map(int,input().split()))
    goal=list(map(int,input().split()))
    board=[[0 for i in range(l)] for j in range(l)]
    board[now[0]][now[1]]=1
    queue=deque([])
    queue.append(now)
    knight()
    print(board[goal[0]][goal[1]]-1)