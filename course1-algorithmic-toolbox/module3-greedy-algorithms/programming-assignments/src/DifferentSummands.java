import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();

        if(n > 2) {
            int indexLast = 0;
            summands.add(1);
            n--;
            while(n - (summands.get(indexLast)+1) > summands.get(indexLast) + 1) {
                summands.add(summands.get(indexLast) + 1);
                indexLast++;
                n = n - summands.get(indexLast);
            }
            summands.add(n);
        } else {
            summands.add(n);
        }




        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

