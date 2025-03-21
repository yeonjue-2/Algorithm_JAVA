class Solution {
    final static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int rows = image.length;
        int cols = image[0].length;
        int start = image[sr][sc];

        if (rows == 0 || cols == 0 || start == color) {
            return image;
        }

        boolean[][] visited = new boolean[rows][cols];

        dfs(image, visited, sr, sc, start, color);

        return image;
    }

    public void dfs(int[][] image, boolean[][] visited, int x, int y, int start, int color) {
        int rows = image.length;
        int cols = image[0].length;

        if (x < 0 || x >= rows || y < 0 || y >= cols|| visited[x][y] || image[x][y] != start) {
            return;
        }

        visited[x][y] = true;
        image[x][y] = color;

        for (int[] dir : directions) {
            int xNext = x + dir[0];
            int yNext = y + dir[1];
            dfs(image, visited, xNext, yNext, start, color);
        }
    }

    public static void main(String[] args) {
        Grain75 sol = new Grain75();
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] result = sol.floodFill(image, sc, sr, color);

        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}

// https://leetcode.com/problems/flood-fill/description/
