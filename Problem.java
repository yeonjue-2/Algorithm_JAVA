class Problem {
    public int solution(int sum, int[] coin) {
        int answer = 0;

        // 각 수들을 만드는 방법 수를 저장할 배열 생성
        int[] number = new int[sum+1];
        number[0] = 1;

        for (int i = 0; i < coin.length; i++) {
            for (int j = 1; j < number.length; j++) {
                if (j < coin[i]) {
                    continue;
                }

                number[j] += number[j - coin[i]];
            }
        }

        answer = number[sum];

        return answer;
    }
}

// sum = 4, coin = {1, 2, 3}
