# 별 찍기
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i=1; i <N+1; i++) {
            for (int j=1; j<i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i=N-1 ; i>0 ; i--) {
            for (int j=i; j>0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
 }

# 직사각형 탈출

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[4];
        for (int i=0; i<4; i++) {
            arr[i] = sc.nextInt();
        }

        arr[2] = arr[2] - arr[0];
        arr[3] = arr[3] - arr[1];

        Arrays.sort(arr);

        System.out.println(arr[0]);
    }
 }
