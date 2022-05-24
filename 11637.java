import java.util.Scanner;

public class Prac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while (N-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0, max = 0, index =0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
                if (arr[i] > max) {
                    max = arr[i];
                    index = i + 1;
                }
            }

            int cnt = 0;
            for (int ar: arr) {
                if (ar == max) {
                    cnt++;
                }
            }

            if (cnt == 1) {
                if (max > sum/2) {
                    System.out.println("majority winner " + index);
                } else {
                    System.out.println("minority winner " + index);
                }
            } else {
                System.out.println("no winner");
            }
        }
    }
}
