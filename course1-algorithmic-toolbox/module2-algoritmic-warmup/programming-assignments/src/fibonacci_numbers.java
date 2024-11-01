import java.util.*;

public class fibonacci_numbers {

    private static long calc_fib(int n) {
        if (n <= 1)
            return n;

        return calc_fib(n - 1) + calc_fib(n - 2);
    }

    private static long calc_fib_fast(int n) {
        long [] fibArr = new long[n+1];

        if(n == 0) {
            return 0;
        }

        fibArr[0] = 0;
        fibArr[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibArr[i] = fibArr[i-1] + fibArr[i-2];
        }
        return fibArr[n];
    }

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib_fast(n));
    }
}
