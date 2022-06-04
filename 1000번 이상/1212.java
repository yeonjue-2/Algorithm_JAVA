import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Long.toBinaryString;

public class Prac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String num = br.readLine();
        String[] binary = {"000", "001", "010", "011", "100", "101", "110", "111"};

        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';  // int 형태로 만들어줌
            if (i==0 && cur < 4) {
                if (cur < 3) {
                    sb.append(binary[cur].substring(2));

                } else {
                    sb.append(binary[cur].substring(1));
                }
            } else {
                sb.append(binary[cur]);
            }
        }
        System.out.println(sb);

    }
}