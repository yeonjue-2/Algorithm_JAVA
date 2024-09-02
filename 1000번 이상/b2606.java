public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int cnt = 0;  // 연결된, 방문하지 않은 노드의 개수
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

        visited[1] = true;
        DFS(1);

        System.out.println(cnt);

    }

    private static void DFS(int i) {
        for (Integer num : arr[i]) {
            if (!visited[num]) {
                visited[num] = true;
                cnt++;
                DFS(num);
            }
        }
    }
}

// https://www.acmicpc.net/problem/2606
