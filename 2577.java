import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int number = A * B * C;
        String num = Integer.toString(number);

        for (int i=0; i<10; i++) {
            int count = 0;
            for (int j = 0; j < num.length(); j++) {
                if ((num.charAt(j) - 48) == i) {
                    count++;
                }
            } System.out.println(count);
        }
    }
 }
