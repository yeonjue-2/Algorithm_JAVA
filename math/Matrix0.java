import java.io.IOException;
import java.util.*;

public class Prac {
    public static void solution(int[][] arr) {
        boolean frZero = false; // 첫번째 열에 원소가 0인 게 있는지
        boolean fcZero = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    if (i == 0) {
                        frZero = true;
                    }
                    if (j == 0) {
                        fcZero = true;
                    }
                    arr[i][0] = 0;
                    arr[0][j] = 0; // 외곽 부분을 0으로 변경
                }
            }
        }

        // 외곽이 아닌 안쪽부터 행렬을 순회하며 외곽 원소를 참고하며 원소를 0으로 변경
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        // 외곽부분들 처리
        if (frZero) {
            for (int i = 0; i < arr[0].length; i++) {
                arr[0][i] = 0;
            }
        }
        if (fcZero) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println(" ");
        }

    }




    public static void main(String[] args) throws IOException {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution(matrix);

        int[][] matrix2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        solution(matrix2);
    }
}

/*
  정수로 이루어진 M x N 행렬 데이터가 있다.
  행렬의 원소 중 0이 있을 경우 해당 원소가 위치하는 행과 열 전체 데이터를 0으로 변경하는 코드를 작성하라

  예시)
  {{1, 1, 1},      ->     {{1, 0, 1},
   {1 ,0, 1},              {0, 0, 0},
   {1, 1, 1}}              {1, 0, 1}}
 */

/*
  문제해결 방법
  1. 0이 있는 행과 열을 체크하여 행과 열의 외곽 원소를 0으로 바꾸어두고 외곽이 아닌 안쪽의 원소를 for문을 돌며
     외곽 원소를 기준으로 0으로 바꿈
  2. 외곽은 한번더 for문을 돌며 원소를 0으로 바꿈
  * 외곽은 0행과 0열을 말함
 */
