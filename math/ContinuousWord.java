public class ContinuousWord {

    final static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static boolean solution(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visited, int x, int y, int i, String word) {
        int rows = board.length;
        int cols = board[0].length;

        if (i == word.length()) return true;                          // dfs로 끝까지 도달한 경우
        if (x < 0 || x >= rows || y < 0 || y >= cols) return false;   // 범위를 벗어나는 경우
        if (visited[x][y]) return false;                              // 이미 방문한 경우
        if (board[x][y] != word.charAt(i)) return false;              // 해당 문자가 같지 않은 경우

        visited[x][y] = true;
        for (int[] dir : directions) {
            int xNext = x + dir[0];
            int yNext = y + dir[1];
            if (dfs(board, visited, xNext, yNext, i+1, word)) {
                return true;
            }
        }
        visited[x][y] = false;

        return false;

    }

    public static void main(String[] args) {
        // Test code
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution(board, "ABCCED"));
        System.out.println(solution(board, "SEE"));
        System.out.println(solution(board, "ABCB"));
    }
}


// 문제 설명
/*
  row x col 행렬 형태의 board 와 word 문자열이 주어졌을 때,
  해당 행렬에서 word 문자열이 인접하게 연결되어 있는지를 확인하는 프로그램을 작성하세요.
  
  아래와 같은 행렬에서 word 로 "ABCCED" 가 주어진 경우 다음과 같이 인접해 있음을 확인할 수 있다.
  A B C E
  S F C S
  A D E E
  
  인접하게 구성이되면 true 를 반환하고 그렇지 않으면 false 를 반환하시오.
  
  입출력 예시
  board	word	결과
  {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}	"ABCCED"	true
  {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}	"SEE"	true
  {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}	"ABCB"	false
*/
