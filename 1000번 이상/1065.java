import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 99;

        if (N <= 99) {
            cnt = N;
        } else {
            for (int i = 100; i < N+1; i++) {
                String[] arr = Integer.toString(i).split("");                   // [1, 0, 0]
                int gap = Integer.valueOf(arr[0]) - Integer.valueOf(arr[1]);

                for (int j = 1; j < arr.length-1; j++) {
                    if (Integer.valueOf(arr[j]) - Integer.valueOf(arr[j+1]) == gap) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}


// 99 보다 같거나 작은 수일 경우 해당 수 까지 모두 한수
// 그 이상일 경우 판별 해야함
// 100부터 해당 수까지의 수를 한 자리씩 떼어서 리스트로 만듦
// 각 자리 수의 차이를 저장하고 차이가 같으면 한수로 인식 -> cnt +1


