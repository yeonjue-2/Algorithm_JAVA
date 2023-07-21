class Problem {
    public int solution(int sum, int[] coin) {
        int answer = 0;

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
