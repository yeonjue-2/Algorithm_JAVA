class Problem2 {
    public static int solution(List<Integer> cost, int x) {
        int answer = 0;

        for (int i = cost.size()-1; i >= 0; i--) {
            if (cost.get(i) <= x) {
                x -= cost.get(i);
                answer += Math.pow(2, i);
            }
            if (x <= 0) {
                break;
            }
        }

        return answer;
    }
