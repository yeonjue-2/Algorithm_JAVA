import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();

        int[] list1 = {1, 2, 3, 4, 5};
        int[] list2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] list3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] count = {0, 0, 0};       // list1, 2, 3의 정답 수

        for (int i = 0; i < answers.length; i++) {
            if (list1[i % 5] == answers[i]) {         // 값이 같을때마다 count += 1
                count[0] += 1;
            }

            if (list2[i % 8] == answers[i]) {
                count[1] += 1;
            }

            if (list3[i % 10] == answers[i]) {
                count[2] += 1;
            }
        }

        int[] arr = new int[count.length];      
        for (int i = 0; i < arr.length; i++) {
            arr[i] = count[i];
        }

        Arrays.sort(arr);                         // 1, 2, 3의 count를 정렬하여 저장

        for (int i = 0; i < arr.length; i++) {    // 최댓값과 같은 수만 저장
            if (count[i] == arr[2]) {
                answer.add(i+1);
            }
        }

        return answer;
    }
}
