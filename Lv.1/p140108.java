class Zoo {
    public int solution(String s) {
        int answer = 0;

        String sub = s;

        while (sub.length() > 2) {
            int i = 1;
            int j = 0;

            char c = sub.charAt(0);

            for (int k = 1; k < sub.length(); k++) {
                if (i == j) {
                    sub = sub.substring(k);
                    answer += 1;
                    break;
                }

                if (sub.charAt(k) == c) {
                    i++;
                } else if (sub.charAt(k) != c) {
                    j++;
                }
            }
            continue;
        }


        return answer + 1;
    }
}

// 시간초과가 떴다.


public int solution(String s) {
        int answer = 0;
        String sub = s;

        while (sub.length() > 0) {
            answer++;
          
            int i = 1;
            int j = 0;
            char c = sub.charAt(0);

            for (int k = 1; k < sub.length(); k++) {
                if (i == j) {
                    break;
                }

                if (sub.charAt(k) == c) {
                    i++;
                } else {
                    j++;
                }
            }
            sub = sub.substring(i+j);
        }

        return answer;
    }
// 분기문 조건을 조금 변형시키니 통과 
// 반례문을 볼 수 있으며 좋았겠다는 마음이 든다.



// 다른 사람 풀이

public int solution(String s) {
        char prev = '1';
        int same = 0, different = 0, answer = 0;
        for (char c : s.toCharArray()) {
            if (prev == '1') {
                prev = c;
                same++;
                answer++;
            } else if (prev == c) {
                same++;
            } else {
                different++;
            }

            if (same == different) {
                prev = '1';
                same = 0; different = 0;
            }
        }

        return answer;
    }

// 속도는 원래 좀 소요되는 것 같다.

// https://school.programmers.co.kr/learn/courses/30/lessons/140108#
