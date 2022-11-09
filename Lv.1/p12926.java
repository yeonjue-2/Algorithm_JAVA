class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        char[] chars = s.toCharArray();

        for (int i = 0; i <= chars.length-1 ; i++) {
            int num = (int) chars[i];

            if (num == 32) {
                chars[i] = (char) num;
            } else if (num >= 65 && num <= 90) {
                if (num + n > 90) {
                    chars[i] = (char) (((num + n)%90) + 64);
                } else {
                    chars[i] = (char) (num + n);
                }
            } else if (num >= 97 && num <= 122) {
                if (num + n > 122) {
                    chars[i] = (char) (((num + n)%122) + 96);
                } else {
                    chars[i] = (char) (num + n);
                }
            }
        }

        for (char ch : chars) {
            answer.append(ch);
        }

        return answer.toString();
    }
}

// 다른 풀이 
class Caesar {
    String caesar(String s, int n) {
        String result = "";
    n = n % 26;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isLowerCase(ch)) {
        ch = (char) ((ch - 'a' + n) % 26 + 'a');
      } else if (Character.isUpperCase(ch)) {
        ch = (char) ((ch - 'A' + n) % 26 + 'A');
      }
      result += ch;
    }
        return result;
    }
}
