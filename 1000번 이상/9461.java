// 나의 풀이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] p = new long[101];
        p[0] = 1;
        p[1] = 1;
        p[2] = 1;
        p[3] = 2;
        p[4] = 2;


        while (N >= 1) {
            int M = Integer.parseInt(br.readLine());
            if (M - 1 > 4) {
                for (int i = 5; i < M; i++) {
                    p[i] = (p[i-5] + p[i-1]);
                }
            }
            System.out.println(p[M-1]);
            N--;
        }
    }
}


// dp, memoization 활용 풀이
public class Main {

    static long[] p = new long[101];

    static long dp(int n) {
        p[n] = p[n-5] + p[n-1];    # 기억해두고 불러오기
        return p[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        p[0] = 1;
        p[1] = 1;
        p[2] = 1;
        p[3] = 2;
        p[4] = 2;


        while (N >= 1) {
            int M = Integer.parseInt(br.readLine());
            if (p[M-1] == 0) {
                for (int i = 5; i < M; i++) {
                    dp(i);
                }
            }
            System.out.println(p[M-1]);
            N--;
        }
    }
}
