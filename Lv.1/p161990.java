class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        Set<Integer> ansR = new HashSet<>();
        Set<Integer> ansC = new HashSet<>();

        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                ansR.add(i);
                for (int j = 0; j < wallpaper[i].length(); j++) {
                    if (wallpaper[i].charAt(j) == '#') {
                        ansC.add(j);
                    }
                }
            }
        }

        answer[0] = Collections.min(ansR);
        answer[1] = Collections.min(ansC);
        answer[2] = Collections.max(ansR) + 1;
        answer[3] = Collections.max(ansC) + 1;

        return answer;
    }
}

// 통과 (0.17ms, 67.7MB)
// indent 4라서 보기에 별로였다.


class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int i=0; i< wallpaper.length;i++ ){
            for(int j=0; j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minX = Math.min(minX,i);
                    minY = Math.min(minY,j);
                    maxX = Math.max(maxX,i);
                    maxY = Math.max(maxY,j);
                }
            }
        }
        return new int[]{minX,minY,maxX+1,maxY+1};
    }
}

// 통과 (0.05ms, 75.5MB)
// 확실히 문제를 잘 봐야하는 게 범위가 그렇게 크지 않을때는 아예 정해놓고 시작하는 편이 빠를 것 같다.
// 행이 최대 51까지라 51를 최대 수로 잡아도 문제없었다.
// 앞으로 최소, 최대 문제가 나올 때는 고려해봐야겠다.

// https://school.programmers.co.kr/learn/courses/30/lessons/161990
