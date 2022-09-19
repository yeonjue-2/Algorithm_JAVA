public class Pracc {
    static int[][] Cost;
    static int[][] DP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
      
        Cost = new int[N][3];
        DP = new int[N][3];

        StringTokenizer st;
      
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            Cost[i][0] = Integer.parseInt(st.nextToken());
            Cost[i][1] = Integer.parseInt(st.nextToken());
            Cost[i][2] = Integer.parseInt(st.nextToken());
        }

        DP[0][0] = Cost[0][0];        // DP의 첫값은 Cost의 첫 값
        DP[0][1] = Cost[0][1];
        DP[0][2] = Cost[0][2];


        System.out.println(Math.min(cost(N- 1, 0), Math.min(cost(N - 1, 1), cost(N - 1, 2))));
    }

    static int cost(int N, int n) {
        if(DP[N][n] == 0) {           // 만약 탐색하지 않은 배열이라면
          
            if(n == 0) {
                DP[N][0] = Math.min(cost(N - 1, 1), cost(N - 1, 2)) + Cost[N][0];     // 현재 값에 이전 행의 다른 index 중 작은 값을 더해 저장
            }
            else if(n == 1) {
                DP[N][1] = Math.min(cost(N - 1, 0), cost(N - 1, 2)) + Cost[N][1];
            }
            else {
                DP[N][2] = Math.min(cost(N - 1, 0), cost(N - 1, 1)) + Cost[N][2];
            }
          
        }

        return DP[N][n];
    }
}
