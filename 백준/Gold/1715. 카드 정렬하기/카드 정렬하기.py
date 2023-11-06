#1715 카드 정렬하기
import sys
import heapq
input=sys.stdin.readline

n=int(input())
ans=0
if n==1:
    print(ans)
else:
    heap=[]
    for _ in range(n):
        heapq.heappush(heap,int(input()))
    while 1:
        n1=heapq.heappop(heap)
        n2=heapq.heappop(heap)
        ans+=n1+n2
        if heap:
            heapq.heappush(heap,n1+n2)
        else:
            break
    print(ans)