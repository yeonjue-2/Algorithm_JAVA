import java.util.Scanner;

public class BJ2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] apart = new int[15][15];

        for (int i = 0; i < 15; i++) {
            apart[i][1] = 1;
            apart[0][i] = i;
        }

        for (int i = 1; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = 1; j < 15; j++) {
                for (int m = 2; m < 15; m++) {
                    apart[j][m] = apart[j][m-1] + apart[j-1][m];
                }
            }
            System.out.println(apart[a][b]);
        }
    }
}

