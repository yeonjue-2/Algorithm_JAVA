public class PerfectBinaryTree {
    public static void solution(int n) {
        int[] tree = new int[(int) Math.pow(2, n)];
        tree[0] = 0;

        for (int i = 0; i < Math.pow(2, n-1) - 1; i++) {
            tree[i*2+1] = 0;
            tree[i*2+2] = 1;
        }

        inOrder(tree, 0);
        System.out.println(" ");
    }

    public static void inOrder(int[] arr, int idx) {
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;

        if (left < arr.length - 1) {
            inOrder(arr, left);
        }
        System.out.print(arr[idx] + " ");
        if (right < arr.length - 1) {
            inOrder(arr, right);
        }
    }

    public static void main(String[] args) {
        solution(1);
        solution(2);
        solution(3);
    }
}

/*
  종이를 반으로 접었을 때 안으로 파인 골은 0, 튀어나온 골은 1이라 하자.
  종이를 접을때는 오른쪽에서 왼쪽으로 접는다.
  종이를 n번 접었을 때의 접힌 상태를 출력하는 문제를 작성하라.
  
  입출력 예시
  입 : 1
  출 : 0
  
  입 : 2
  출 : 0 (0) 1
  
  입 : 3
  출 : 0 0 1 (0) 0 1 1
 */

/*
  문제해결 방법
  1. 규칙을 보면 중간 노드를 기준으로 왼쪽 0, 오른쪽 1을 채우는 포화 이진 트리 모양이라는 것을 알 수 있음
  2. 중위순회하고 있으므로 중위순회로 출력
  3. 참고 그림 - https://www.notion.so/eefaed1209ed44e3b6e8a36bde998c57?pvs=4#16b9019a28938013b05ed748c55ad55c
 */
