import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());       //  총 참여 국가
        int M = Integer.parseInt(st.nextToken());       // 알고 싶은 국가 넘버
        int[][] arr = new int[N-1][3];      // 비교할 국가들의 메달  배열
        int[] target = new int[3];          // 알아볼 국가의 매달 배열
        
        int arrnum = 0;                     // arr는 N-1 행이라 N번 도는 for문에서 어긋남

        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            if (Integer.parseInt(str.nextToken()) == M) {
                for (int j = 0; j < 3; j++) {
                    int medal = Integer.parseInt(str.nextToken());                     // target = [0, 1, 0]
                    target[j] = medal;
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    int medal = Integer.parseInt(str.nextToken());                     // arr = [1, 2, 0],
                    arr[arrnum][j] = medal;                                            //       [0, 1, 0],
                }                                                                      //       [0, 0, 1]
                arrnum++;
            }
        }

        int rank = 1;      // 나라 순위
        for (int i = 0; i < N-1; i++) {
            if (arr[i][0] > target[0]) {
                rank++;
            } else if (arr[i][0] == target[0] && arr[i][1] > target[1]) {
                rank++;
            } else if (arr[i][0] == target[0] && arr[i][1] == target[1] && arr[i][2] > target[2]) {
                rank++;
            }
        }
        System.out.println(rank);
    }
}




