
while True:
    try:
        n = int(input())
        list = list(map(int, input().split()))
        print(n)
        print(list)
    except EOFError:
        break