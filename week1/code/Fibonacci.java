public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();

        System.out.println("Recursion Solution");
        long start = currentTime();
        System.out.println(fib.recFib(50));
        long end = currentTime();
        System.out.println("Time in second: " + timeDiff(start, end));

        System.out.println("Memo Solution");
        start = currentTime();
        System.out.println(fib.memoFibRunner(50));
        end = currentTime();
        System.out.println("Time in second: " + timeDiff(start, end));

        System.out.println("Dynamic Programming Solution");
        start = currentTime();
        System.out.println(fib.dpFib(50));
        end = currentTime();
        System.out.println("Time in second: " + timeDiff(start, end));

    }

    public long recFib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return recFib(n - 1) + recFib(n - 2);
        }
    }

    public long memoFib(int n, long[] memo) {
        long tempResult;
        if (0 != memo[n - 1]) {
            return memo[n - 1];
        }
        if (n == 1 || n == 2) {
            tempResult = 1;
        } else {
            tempResult = memoFib(n - 1, memo) + memoFib(n - 2, memo);
        }
        memo[n - 1] = tempResult;
        return tempResult;
    }

    public long memoFibRunner(int n) {
        long[] memo = new long[n];
        return memoFib(n, memo);
    }

    public long dpFib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        long[] seq = new long[n];
        seq[0] = 1;
        seq[1] = 1;
        for (int i = 2; i < n; i++) {
            seq[i] = seq[i - 1] + seq[i - 2];
        }
        return seq[n - 1];
    }

    public static long currentTime() {
        return System.currentTimeMillis();
    }

    public static long timeDiff(long start, long end) {
        return ((end - start));
    }

}