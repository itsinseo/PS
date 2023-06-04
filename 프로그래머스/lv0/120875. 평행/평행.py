def solution(dots):
    answer=0
    for i in range(1, len(dots)):
        a=(dots[0][0]-dots[i][0])/(dots[0][1]-dots[i][1])
        b=(dots[(i%3)+1][0]-dots[((i+1)%3)+1][0])/(dots[(i%3)+1][1]-dots[((i+1)%3)+1][1])
        if a==b:
                answer=1
    return answer