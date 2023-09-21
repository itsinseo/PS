#1436 영화감독 숌

import sys

input=sys.stdin.readline

n=int(input())

lst=[]

i=0

while(len(lst)<=10000):
    i+=1
    if "666" in str(i):
        lst.append(i)

print(lst[n-1])