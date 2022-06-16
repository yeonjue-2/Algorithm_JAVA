import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] strarr = str.split("");
            int sum = 0;
            int cnt = 1;

            for (int j = 0; j < strarr.length; j++) {
                if (strarr[j].equals("O")) {
                    sum += cnt;
                    cnt++;
                } else if (strarr[j].equals("X")) {
                    cnt = 1;
                }
            }
            System.out.println(sum);
        }

    }
}
