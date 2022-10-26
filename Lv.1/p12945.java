class Solution {
    public int solution(int n) {

        ArrayList<Integer> f = new ArrayList<>();

        f.add(0);
        f.add(1);
        f.add(1);

        for (int i = 3; i < n+1; i++) {
            f.add(f.get(i-2) % 1234567 + f.get(i-1) % 1234567);
        }

        return f.get(n) % 1234567;
    }
}
