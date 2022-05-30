// 내풀이
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int hour = A;
        int min = B + C;
        int cnt = 0;
        int remain = 0;

        if (min >= 60) {
            cnt = min / 60;
            remain = min%60;
            min = remain;
            if ((A + cnt)>23) {
                hour = (A+cnt)%24;
            } else {
                hour = A + cnt;
            }
        }

        System.out.println(hour + " " + min);
    }
 }

// 남풀이

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String time = br.readLine();
		String cook_time = br.readLine();
		
		String [] str = time.split(" ");
		
		int sum = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]) + Integer.parseInt(cook_time);
		int hour = sum/60%24;
		int min = sum%60;
		
		System.out.print(hour + " " + min);
	}	
}
