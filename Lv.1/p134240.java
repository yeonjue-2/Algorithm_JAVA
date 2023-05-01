class Solution {
    public String solution(int[] food) {
        String answer = "";
        String anw = "";
        String reverse = "";

        for (int i=1; i<food.length; i++) {
            for (int j=0; j<food[i] / 2; j++) {
                anw += i;
            }
        }

        for (int i=anw.length()-1; i>-1; i--) {
            reverse += anw.charAt(i);
        }

        answer = anw + "0" + reverse;

        return answer;
    }
}
// 통과 (15.22ms, 80.1MB)


// StringBuilder를 쓰는 것이 공간을 많이 잡아 먹을거라 생각했다.

public String solution(int[] food) {
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < food.length; i++) {
        for (int j = 0; j < food[i] / 2; j++) {
            sb.append(i);
        }
    }

    return sb.toString() + "0" + sb.reverse().toString();
}

// 통과 (13.02ms, 88.8MB)
// 공간을 더 잡아먹기는 하지만 성능이 좀더 개선되었고 큰 차이가 없으니
// 가독성 면에서 더 나은 방식인 것 같다. 
// 아직 메모리감은 와닿지 않는다.
// https://school.programmers.co.kr/learn/courses/30/lessons/134240

