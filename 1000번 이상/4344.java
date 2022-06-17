import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[M];
            int sum = 0;

            for (int i = 0; i < M; i++) {
                int score = Integer.parseInt(st.nextToken());
                arr[i] = score;
                sum += arr[i];
            }
            int avg = sum / M;
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                if (arr[i] > avg) {
                    cnt++;
                }
            }

            double m = 100/ (double) M;          // 하나라도 double 이어야 소수점 값 도출
            double ratio = cnt * m;
            String Ratio = String.format("%.3f", ratio);    // 소수점 아래 3자리만
            System.out.println(Ratio + "%");
        }
    }
}
