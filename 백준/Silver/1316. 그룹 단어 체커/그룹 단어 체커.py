n=int(input())
ans=0
for i in range(n):
    a=input()
    lst=[a[0]]
    for j in a:
        if lst[-1]!=j:
            lst.append(j)
    if len(lst)==len(set(lst)):
        ans+=1
print(ans)