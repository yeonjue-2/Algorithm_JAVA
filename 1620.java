package Prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Prac {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i=0; i<N; i++) {
            String mon = br.readLine();
            String number = Integer.toString(i+1);
            map.put(number, mon);
            map.put(mon, number);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            sb.append(map.get(br.readLine()) + "\n");
        }
        System.out.println(sb);
    }
}
