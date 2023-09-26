#1748 수 이어 쓰기1
n=int(input())
l=0
d=1
while(1):
    if n>=(10**d):
        l+=9*(10**(d-1))*d
        d+=1
    else:
        l+=(n-(10**(d-1))+1)*d
        break
print(l)