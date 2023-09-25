#m 이상 n이하 중 소수를 구하기

m, n=map(int,input().split())

for i in range(m,n+1):
    brk=0
    for j in range(2,int(i**0.5)+1):
        if i%j==0:
            brk=1
            break
    if brk==0:
        if i!=1:
            print(i)