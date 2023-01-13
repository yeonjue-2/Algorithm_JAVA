class Solution {
    public String solution(String s) {
        String answer = "";

        s += "1";
        String[] result = s.split(" ");

        for (int i = 0; i < result.length; i++) {
            String trans = "";
            for (int j = 0; j < result[i].length(); j++) {
                if (j % 2 == 0) {
                    trans += Character.toString(result[i].charAt(j)).toUpperCase();
                } else {
                    trans += Character.toString(result[i].charAt(j)).toLowerCase();
                }
            }
            result[i] = trans;
        }

        answer = String.join(" ", result).replace("1", "");

        return answer;
    }
}

// 항상 느끼지만 문제를 꼼꼼히 읽자. 
// 대소문자만 변경 후 문자열을 그대로 반환해야하기 때문에 문자열 끝의 공백도 인식하기 위해 1 넣음.




# 다른 풀이
class Solution {
  public String solution(String s) {
        char[] chars = s.toCharArray();
        int idx = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                idx = 0;
            else
                chars[i] = (idx++ % 2 == 0 ? Character.toUpperCase(chars[i]) : Character.toLowerCase(chars[i]));
        }

        return String.valueOf(chars);
  }
}

// 인덱스번호를 공백일 때 0으로 초기화 시켜서 그 다음부터 차례대로 증가시킨다!! 굿!!
