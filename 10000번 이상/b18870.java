// 시간초과 풀이
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];                      // 원래 좌표 저장 배열
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i <N ; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }

        HashSet<Integer> set = new HashSet<>(Arrays.asList(arr)); // 좌표 배열을 set으로 저장
        Integer[] arr_1 = set.toArray(new Integer[0]);            // 정렬할 수 있게 배열로 바꿈
        Arrays.sort(arr_1);                                       // {-10, -9, 2, 4}

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(Arrays.asList(arr_1).indexOf(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}


// map을 활용한 풀이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prac{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];                   // 원래 좌표 저장 배열
        int[] arr_1 = new int[N];                 // 저장 배열 정렬용 배열
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i <N ; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = arr_1[i] = n;
        }

        Arrays.sort(arr_1);                      // {-10, -9, 2, 4, 4}
        
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for (int i : arr_1) {
            if (!map.containsKey(i)) {
                map.put(i, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}


