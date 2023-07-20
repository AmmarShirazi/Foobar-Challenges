
def solution(xs):

    if (len(xs) == 0):
        return "0"
    if (len(xs) == 1):
        return str(xs[0])
    
    sol = 1
    zero_count = 0
    negative_count = 0
    min_neg = -50000

    for val in xs:
        if val == 0:
            zero_count += 1
        elif val < 0:
            
            if val > min_neg:
                min_neg = val

            sol *= val
            negative_count += 1
        else:
            sol *= val


    if zero_count == len(xs):
        return "0"

        
    if zero_count == len(xs) - 1 and negative_count == 1:
        return "0"

    if negative_count % 2 != 0:
        sol = sol/min_neg
    



    return str(int(sol))



print(solution([2, 0, 2, 2, 0]))
print(solution([-2, -3, 4, -5]))
print(solution([0, -1, 0, 0]))
