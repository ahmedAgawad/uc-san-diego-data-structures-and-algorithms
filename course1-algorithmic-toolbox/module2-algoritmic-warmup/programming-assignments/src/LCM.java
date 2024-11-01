import java.util.*;

public class LCM {
    private static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }

    private static long gcd_efficient(long a, long b) {
        if(b == 0) {
            return a;
        }

        return gcd_efficient(b,a%b);
    }


    private static long lcm_efficient(long a, long b) {
        long gcdNum = gcd_efficient(a,b);
        if(a < b) {
            return a/gcdNum * b;
        } else {
            return b/gcdNum * a;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm_efficient(a, b));
    }
}