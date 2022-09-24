class Solution {
    public int solution(String dartResult) {
        int[] arr = new int[3];             	// 각 라운드의 점수를 저장할 배열
        char[] c = dartResult.toCharArray();	// 문자열을 하나씩 char로 바꿔서 배열 저장
        int idx = -1;							// index 초기값 설정이 중요

        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {		// 숫자일때만 index 값이 증가해야함
                idx++;
                arr[idx] = Integer.parseInt(String.valueOf(c[i]));

                if (c[i] == '1' && c[i+1] == '0' && i+1 != c.length -1) {	  // 10점일 경우 두자리 잡아먹음
                    arr[idx] -= Integer.parseInt(String.valueOf(c[i]));
                    arr[idx] = 10;
                    i++;               				// 이걸 생각 못했었음!
                }
                
            } else if (c[i] == 'D') {
                arr[idx] *= arr[idx];
            } else if (c[i] == 'T') {
                arr[idx] *= arr[idx] * arr[idx];
            } else if (c[i] == '*') {
                arr[idx] *= 2;
                if (idx >= 1) {
                    arr[idx-1] *= 2;
                }
            } else if (c[i] == '#') {
                arr[idx] *= -1;
            }

        }

        return arr[0] + arr[1] + arr[2];
    }
}
