class Solution {
    public long solution(int n) {
        long answer = 0;
        List<Integer> list = new ArrayList<>();

        list.add(0);
        list.add(1);
        list.add(2);

        for (int i = 3; i < n+1; i++) {
            list.add(list.get(i-2) % 1234567 + list.get(i-1) % 1234567);
        }

        answer = list.get(n) % 1234567;

        return answer;
    }
}
