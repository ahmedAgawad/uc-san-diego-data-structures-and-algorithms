import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        return (m/10) + ((m%10)/5) + (m%10)%5;



    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

