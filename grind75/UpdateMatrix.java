public class UpdateMatrix {
    public static int[][] dirs = {{0,-1}, {0,1}, {1,0}, {-1,0}};
  
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                } else {
                    mat[i][j] = -1;  // 나중에 처리할 값 마킹
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) continue;
                mat[nr][nc] = mat[row][col] + 1;
                queue.offer(new int[]{nr, nc});  // 새로 넣어줌
            }
        }
        return mat;
    }
}
