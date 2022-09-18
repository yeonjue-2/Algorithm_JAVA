class Solution {
       public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int max = 0;
        int min = 0;
        int zero_cnt = 0;

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] != 0) {
                for (int j = 0; j < lottos.length; j++) {
                    if (lottos[i] == win_nums[j]) {
                        min++;
                    }
                }
            } else {
                zero_cnt++;
            }
        }

        max = zero_cnt + min;
        answer[0] = max;
        answer[1] = min;


        for (int i = 0; i < 2; i++) {
            int num = answer[i];
            switch (num) {
                case 6:
                    return answer[i] = 1;                    
                case 5:
                    return answer[i] = 2;
                case 4:
                    return answer[i] = 3;
                case 3:
                    return answer[i] = 4;
                case 2:
                    return answer[i] = 5;
                default:
                    return answer[i] = 6;
            }
        }
        return answer;
    }
}
