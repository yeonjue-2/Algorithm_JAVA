import java.util.Arrays;

// 1, 2, 3, 4 를 이용하여 세자리 자연수 만들기
// -> 순열 (순서 O, 중복 X) -> 4P3 = 4 * 3 * 2 = 24

class Permutation {
    public static void permutation(int[] arr, int depth, int n, int r, boolean[] visited, int[] out) {

        if (depth == r) {
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth + 1, n, r, visited, out);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = 4;
        int r = 3;
        boolean[] visited = new boolean[n];
        int[] out = new int[r];
        permutation(arr, 0, n, r, visited, out);
    }
}
