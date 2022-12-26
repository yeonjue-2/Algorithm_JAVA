- 전체 범위 길이만큼의 배열을 생성 (-100 ~ 100)
- lines의 범위 만큼 배열의 값 ++
- 배열에서 값이 2이상인 곳의 합 구하기

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] arr = new int[200];

        for (int[] line: lines) {
            for (int i = line[0]+100; i < line[1]+100; i++) {
                arr[i] += 1;
            }
        }

        for (int i = 0; i < 200; i++) {
            if (arr[i] >= 2) {
                answer++;
            }
        }

        return answer;
    }
}
