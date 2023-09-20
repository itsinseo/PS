#24416 알고리즘 수업-피보나치 수1

def fib(n):
    dp=[0]*(n+1)
    dp[1],dp[2]=1,1
    for i in range(3,n+1):
        dp[i]=dp[i-1]+dp[i-2]
    return dp[n]

def fibonacci(n):
    dp=[0]*(n+1)
    dp[1],dp[2]=1,1
    cnt=0
    for i in range(3,n+1):
        dp[i]=dp[i-1]+dp[i-2]
        cnt+=1
    return cnt
    
n=int(input())

print(fib(n),fibonacci(n))