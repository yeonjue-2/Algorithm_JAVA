import java.io.*;
import java.util.StringTokenizer;

public class Prac {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        long total = 0;
        int max = 0;
        int min = 0;
        int mid = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                total += arr[i][j];
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }

        while (min + 1 < max) {
            mid = (min + max) / 2;
            long cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; i++) {
                    if (arr[i][j] > mid) {
                        cnt += mid;
                    } else {
                        cnt += arr[i][j];
                    }
                }
            }

            if ((double) cnt / total >= 0.5) {
                max = mid;
            } else {
                min = mid;
            }
        }
        System.out.println(max);
    }
}