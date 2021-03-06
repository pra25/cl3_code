import json

def isattack(board,row,column):
    #vertical
    for i in range(n):
        if board[i][column]==1:
            return True
    #diagonal up left
    i=row -1 
    j=column -1
    while i>=0 and j>=0:
        if board[i][j]==1:
            return True
        i = i-1
        j=j-1
    #diagonal up right
    i=row-1
    j = column +1
    while i>=0 and j<n:
        if board[i][j]==1:
            return True
        i=i-1
        j=j+1
    return False    
            

def solve(board,row):
    for i in range(n):
        if (not isattack(board,row,i)):
            board[row][i] = 1
            if row==n-1:
                return True
            else:
                if(solve(board,row+1)):
                    return True
                else:
                    board[row][i] = 0
        
    return False
if __name__=="__main__":
    n = 8
    board = [[0 for x in range(n)] for x in range(n)]
    data = []
    with open('input.json','rt') as f:
        data = json.load(f)        
    print data
    
    board[0][data['start']]=1
    #print board
    if(solve(board,1)):
        print "Problem solved"
        for item in board:
            print item
    else:
        print "Problem not solved"
    
    
