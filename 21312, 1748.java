# 21312

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 1;
        int result2 = 1;
        int[] arr = new int[3];
        boolean odd = false;

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i]%2 == 1) {
                result *= arr[i];
                odd = true;                 // odd 표시
            } else {
                result2 *= arr[i];
            }
        }

        if (odd) {
            System.out.println(result);     // 하나라도 odd라면
        } else {
            System.out.println(result2);
        }



    }
}


# 1748
  
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result =  0;
        int cntnumber = 1;
        int numlen = 10;

        for (int i = 1; i <=N ; i++) {
            if (i == numlen) {        // 10, 100 커질수록
                numlen *= 10;
                cntnumber++;          // 더하는 자릿수도 
            }
            result += cntnumber;
        }
        System.out.println(result);
    }
}
