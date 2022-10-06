class Solution {
   public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            if (i == phone_book.length - 1) break;
            if (phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
            }
        }

        return answer;
    }
}


// 시간초과 났던 풀이
// 이중 포문이었고 contains를 사용하면 시작하는지를 알 수 없다.

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if (i != j) {
                    if (phone_book[j].contains(phone_book[i])) {
                        answer = false;
                    }
                }
            }
        }
