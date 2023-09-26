#2309 일곱 난쟁이

import sys
input=sys.stdin.readline
# input=open("0.txt","r").readline

lst=[]
for i in range(9):
    lst.append(int(input()))

s=sum(lst)

for i in range(len(lst)):
    brk=0
    a=lst[i]
    for j in range(i+1,len(lst)):
        b=lst[j]
        if s-a-b==100:
            lst.remove(a)
            lst.remove(b)
            brk=1
            break
    if brk==1:
        break
        
lst.sort()
print(*lst,sep='\n')