class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        int[] arr = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            int N = Integer.parseInt(str[i]);
            arr[i] = N;
        }

        Arrays.sort(arr);

        answer = arr[0] + " " + arr[str.length -1];

        return answer;
    }
}
