import sys
input = sys.stdin.readline

n = int(input())
lst = [0 for i in range(26)]
answer = ""
for i in range(n):
    s = input().rstrip()
    lst[ord(s[0])-ord("a")]+=1
    
for i in range(26):
    if lst[i]>=5:
        answer+=chr(i+97)
        
if answer:
    print(answer)
else:
    print("PREDAJA")