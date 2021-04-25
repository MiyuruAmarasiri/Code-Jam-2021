import os
import sys
import time


def main():
    if "LOCAL_RUN" in os.environ:
        sys.stdin = open("input.txt", "r")
        sys.stdout = open("output.txt", "w")
        print("local run", file=sys.stderr)

    start = time.time()

    T = int(input())

    for t in range(T):
        print(f"Case #{t + 1}: ", end="")

        n, A, B = list(map(int, input().split()))

        us = list(map(int, input().split()))

        MAX_FIB = 1000
        fib = [0] * (MAX_FIB + 1)
        fib[1] = 1
        for i in range(1, MAX_FIB):
            if i + A <= MAX_FIB:
                fib[i + A] += fib[i]
            if i + B <= MAX_FIB:
                fib[i + B] += fib[i]

        def possible(i, ans):
            # (i + 1) is the cur num
            avail = fib[ans - (i + 1) + 1]

            # subtract what's used for other numbers
            for j in range(i + 1, n):
                avail -= us[j] * fib[j - i + 1]

            return avail

        ans = None

        for ans_i in range(n, MAX_FIB):
            pos = True

            for i in reversed(range(n)):
                if us[i] > possible(i, ans_i):
                    pos = False

            if pos:
                ans = ans_i
                break

        if not ans:
            print("IMPOSSIBLE")
        else:
            print(ans)

    end = time.time()
    print(f"Execution time: {end - start}", file=sys.stderr)


if __name__ == "__main__":
    main()
