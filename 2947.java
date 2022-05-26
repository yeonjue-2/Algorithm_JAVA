import java.util.Scanner;

public class Prac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int k = 0; k < 5; k++) {
            arr[k] = sc.nextInt();
        }

        for (int i = 0; i <5; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[j] > arr[j + 1]) {
                    int item = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = item;
                    for (int ar : arr) {
                        System.out.println(ar + "\t");
                    }
                }
                System.out.println();
            }
        }


    }
}