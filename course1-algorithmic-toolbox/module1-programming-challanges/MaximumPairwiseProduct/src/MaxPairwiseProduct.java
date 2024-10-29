import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = (Math.max(max_product,
                        (long) numbers[first] * numbers[second]));
            }
        }

        return max_product;
    }

    static long getMaxPairwiseProductFast(int [] numbers) {
        int maxIndex1 = -1;
        long max1 = 0;
        for (int i  = 0; i < numbers.length; i++) {
            if(maxIndex1 == -1 || numbers[i] > max1) {
                max1 = numbers[i];
                maxIndex1 = i;
            }
        }

        int maxIndex2 = -1;
        long max2 = 0;
        for (int i = 0; i < numbers.length; i++) {
            if((maxIndex2 == -1 && i != maxIndex1) || (numbers[i] > max2 && i != maxIndex1)) {
                max2 = numbers[i];
                maxIndex2 = i;
            };
        }

        return max2 * max1;
    }



    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
