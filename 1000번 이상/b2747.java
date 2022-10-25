import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Pracc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> f = new ArrayList<>();

        f.add(0);
        f.add(1);

        for (int i = 2; i < N+1; i++) {
            f.add(f.get(i-2) + f.get(i-1));
        }

        System.out.println(f.get(N));
    }
}
