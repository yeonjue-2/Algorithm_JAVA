public String solution(int a, int b) {
        
        int ans = 0;
        int[] arr = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = new String[] {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        for (int i = 0; i < a-1; i++) {
            ans += arr[i];
        }
        ans = ans + b;


        return day[ans%7];
    }


// Calendar 클래스 활용 풀이
import java.util.Calendar;

class Solution {
    public String solution(int a, int b) {

        Calendar cal = Calendar.getInstance();
        cal.set(2016, a-1, b);       // 날짜 설정

        String[] day = new String[] {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int date = cal.get(Calendar.DAY_OF_WEEK) - 1;

        return day[date];
    }
}
