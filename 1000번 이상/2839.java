import java.util.Scanner;

public class Parent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int value = N/5;

        if (N%5 == 0) {
            System.out.println(N/5);
        } else if (N == 4 || N == 7) {
            System.out.println(-1);
        } else if (N == 3 || N==6 || N==9 || N==12) {
            System.out.println(N/3);
        } else {
            for (int i = 1; i <= value; i++) {
                for (int j = 1; j <= 4; j++) {
                    int result = 5 * i + 3 * j;
                    if (N == result) {
                        System.out.println(i + j);
                        break;
                    }
                }
            }
        }
    }
}




다른 풀이
    Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int answer = 0;

        while (true) {
            if (N % 5 == 0) {
                answer += N / 5;
                System.out.println(answer);
                break;
            } else {
                N -= 3;
                answer++;
            }
            if (N < 0) {
                System.out.println("-1");
                break;
            }
        }
