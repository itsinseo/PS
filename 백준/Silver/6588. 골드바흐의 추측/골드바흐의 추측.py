#6588 골드바흐의 추측
import sys
input=sys.stdin.readline

lst=[1 for i in range(1000001)]
lst[0],lst[1]=0,0
prime=[]
for i in range(2,1001):
    if lst[i]==1:
        prime.append(i)
        j=2
        while(i*j<1000001):
            lst[i*j]=0
            j+=1
            
while 1:
    n=int(input())
    if n==0:
        break
    
    gold=0
    for i in prime:
        if lst[i]==1 and lst[n-i]==1:
            print(n,'=',i,'+',n-i)
            gold=1
            break
    
    if gold==0:
        print("Goldbach's conjecture is wrong.")