import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        List<List<Integer>> appleBox = new ArrayList<>();


        Arrays.sort(score);
        int remain = score.length % m;

        for (int i = 0; i < score.length / m; i++) {
            List<Integer> apples = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                apples.add(score[(m * i) + j + remain]);
            }
            appleBox.add(apples);
        }

        for (int i = 0; i < appleBox.size(); i++) {
            if(appleBox.get(i).size() == m) {
                int min = appleBox.get(i).get(0);
                answer += min * m;
            }
        }

        return answer;
    }
}

// 굳이 리스트에 다 넣을 필요가 없었다.




import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        int remain = score.length % m;

        for (int i = 0; i < score.length / m; i++) {
            answer += (score[(m * i) + remain]) * m;
        }

        return answer;
    }
}

// 간략하게 앞의 값들만 더해주어도 되었었다.

import java.util.Arrays;


class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for (int i = score.length - m; i >= 0; i -= m) {
            answer += score[i] * m;
        }

        return answer;
    }
}

// for문을 돌릴 때 변수값 다르게 주어 바로 처리하였다.

