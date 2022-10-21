public class Prac{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            ArrayList<Integer> primes = new ArrayList<>();

            primes.add(1);
            primes.add(1);

            for (int j = 2; j < M-1; j++) {
                primes.add(0);
            }

            int sqrt = (int) Math.sqrt(M);

            for (int j = 2; j < sqrt + 1; j++) {
                if (primes.get(j) == 0) {
                    for (int k = j+j; k < M-1; k += j) {
                        primes.set(k, 1);
                    }
                }
            }

            ArrayList<Integer> prime = new ArrayList<>();

            for (int j = 2; j < primes.size(); j++) {
                if (primes.get(j) == 0) {
                    prime.add(j);                       // {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53}
                }
            }

            int[] arr = new int[]{0, M};

            for (int j = prime.size()-1; j >= 0; j--) {
                int re = M - prime.get(j);
                if (prime.contains(re) && prime.get(j) < arr[1] && prime.get(j) >= M/2) {
                    arr[0] = re;
                    arr[1] = prime.get(j);
                }
            }

            System.out.println(arr[0] + " " + arr[1]);

        }
    }
}



// 다른 풀이 (시간과 메모리를 많이 줄임)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[10001];

        for (int i = 2; i <= Math.sqrt(10000); i++) {           // 해당 범위까지 소수 판별, true는 소수가 아님
            for (int j = i+i; j < 10000; j += i) {
                prime[j] = true;
            }
        }

        while (N-- > 0) {
            int M = Integer.parseInt(br.readLine());
            int x = M/2;                                       // 절반값을 정하고
            int y = M/2;

            int i = 0;      
            while (x - i > 1) {                                // 하나씩 빼고 더한 수가 소수인지 판별
                if (!prime[x - i] && !prime[y + i]) {
                    System.out.println((x-i) + " " + (y+i));
                    break;
                }
                i++;
            }
        }

    }
}
