import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prac{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[1001];
        int sqrt = (int) Math.sqrt(1000);

        prime[1] = true;

        for (int i = 2; i < sqrt+1; i++) {
            for (int j = i+i; j < 1001; j+=i) {
                prime[j] = true;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        while (N-- > 0) {
            int M = Integer.parseInt(st.nextToken());
            if (!prime[M]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
