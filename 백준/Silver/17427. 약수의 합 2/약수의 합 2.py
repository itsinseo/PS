#17427 약수의 합2
n=int(input())
g=0
for i in range(1,n+1):
    g+=i*(n//i)
print(g)