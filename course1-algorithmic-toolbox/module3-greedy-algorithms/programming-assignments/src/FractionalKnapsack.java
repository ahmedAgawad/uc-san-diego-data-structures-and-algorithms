import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here

        /*
        * loop when capacity is bigger than 0
        *    find the one with max vi / wi
        *    get the min(wi , capacity)
        *    value += min(wi, capacity) * (vi/wi)
        *    set values and weights of one with max to 0
        *    capacity - min(wi ,capacity)
        *
        */
        double currentMaxValue = -1;
        int currentMaxIndex = -1;
        int currentTakenCapacity = 0;

        while(capacity > 0) {

            for (int i = 0; i < weights.length; i++ ) {
                if(((double) values[i] / weights[i]) > currentMaxValue) {
                    currentMaxIndex = i;
                    currentMaxValue = (double) values[i] / weights[i];
                }
            }

            if(currentMaxValue <= 0.0) {
                break;
            }

            currentTakenCapacity = Math.min(weights[currentMaxIndex], capacity);
            value += currentTakenCapacity * (currentMaxValue);

            values[currentMaxIndex] = 0;
            weights[currentMaxIndex] = 1;

            capacity -= currentTakenCapacity;
            currentMaxValue = -1;
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.printf("%.4f",getOptimalValue(capacity, values, weights));
    }
} 
