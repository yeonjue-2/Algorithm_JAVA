class Solution {
    public int solution(int n) {
        int answer = 0;

        String nToThree = Integer.toString(n, 3);
        String[] str = new String[nToThree.length()];

        for (int i = nToThree.length()-1; i >= 0; i--) {
            str[nToThree.length()-1 - i] = String.valueOf(nToThree.charAt(i));
        }

        answer = Integer.parseInt(String.join("", str), 3);
        
        return answer;
    }
}




class Solution {
    public int solution(int n) {
        String a = "";

        while(n > 0){
            a = a + (n % 3);
            n /= 3;
        }
        a = new StringBuilder(a).toString();


        return Integer.parseInt(a,3);
    }
}
