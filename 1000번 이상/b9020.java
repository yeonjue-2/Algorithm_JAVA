import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[10001];

        for (int i = 2; i <= Math.sqrt(10000); i++) {           // 해당 범위까지 소수 판별, true는 소수가 아님
            for (int j = i+i; j < 10000; j += i) {
                prime[j] = true;
            }
        }

        while (N-- > 0) {
            int M = Integer.parseInt(br.readLine());
            int x = M/2;                                       // 절반값을 정하고
            int y = M/2;

            int i = 0;      
            while (x - i > 1) {                                // 하나씩 빼고 더한 수가 소수인지 판별
                if (!prime[x - i] && !prime[y + i]) {
                    System.out.println((x-i) + " " + (y+i));
                    break;
                }
                i++;
            }
        }

    }
}
