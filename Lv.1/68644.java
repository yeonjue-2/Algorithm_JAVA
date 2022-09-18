class Solution {
   public ArrayList solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    int num = (numbers[i] + numbers[j]);
                    if (!answer.contains(num)) {
                        answer.add(num);
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;

    }
}
