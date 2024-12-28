import java.io.IOException;
import java.util.*;

public class ContainsKey {
    public static int[] solution(int[] nums, int target) {

        int[] result = new int[2];
        Hashtable<Integer, Integer> ht = new Hashtable<>();

        for (int i = 0; i <nums.length; i++) {
            if (ht.containsKey(nums[i])) {
                result[0] = ht.get(nums[i]);
                result[1] = i;
                return result;
            }
            ht.put(target - nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(new int[]{7,11,5,3}, 10)));
    }
}

/*
   정수형 배열 nums와 target이 주어졌을 때
   nums에서 임의의 두 수를 더해 target을 구할 수 있는지 확인하는 프로그램을 작성하세요
   두 수의 합으로 target을 구할 수 있으면 해당 값의 index를 반환하고 없는 경우 null 반환

   입출력 예시
   nums : 7, 11, 5, 3   target : 10
   출력 : 0, 3

   nums : 8, 3, -2      target : 6
   출력 : 0, 2

   이중포문을 사용할 경우 O(n^2) 시간복잡도가 소요됨
 */
