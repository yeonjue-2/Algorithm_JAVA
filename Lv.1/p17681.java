class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];
        String[] str = new String[n];

        for (int i = 0; i <= n-1; i++) {
            long number = Long.parseLong(Integer.toBinaryString(arr1[i])) + Long.parseLong(Integer.toBinaryString(arr2[i]));
            String binary = String.format("%0"+n+"d", number);
            str[i] = binary;
        }

        Arrays.fill(answer, "");

        for (int i = 0; i <= n-1; i++) {
            for (int j = 0; j <= n-1; j++) {
                if (String.valueOf(str[i].charAt(j)).equals("0")) {
                    answer[i] += " ";
                } else {
                    answer[i] += "#";
                }
            }
        }
        return answer;
    }
}

// 이중포문 대신 replaceAll, 위와 속도차이 없음

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i <= n-1; i++) {
            long number = Long.parseLong(Integer.toBinaryString(arr1[i])) + Long.parseLong(Integer.toBinaryString(arr2[i]));
            String binary = String.format("%0"+n+"d", number);
            answer[i] = binary;
        }

        for (int i = 0; i <= n-1; i++) {
            answer[i] = answer[i].replaceAll("0", " ");
            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("2", "#");
        }

        return answer;
    } 
}

// 속도 개선, 필요할 때 0을 채우는 대신 16자리로 아예 만들고 필요한만큼 자르기

class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
      String[] answer = new String[n];
      String temp;

      for(int i = 0 ; i < n ; i++){
          temp = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
          temp = temp.substring(temp.length() - n);
          temp = temp.replaceAll("1", "#");
          temp = temp.replaceAll("0", " ");
          answer[i] = temp;
      }

      return answer;
  }
}
