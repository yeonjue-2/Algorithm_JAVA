import java.util.Arrays;

public class ProductExceptSelf {
    int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // prefix product
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        // suffix product
        int rightPrd = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightPrd;
            rightPrd *= nums[i];
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(sol.productExceptSelf(nums)));

        // Input: nums = [1,2,3,4]
        // Output: [24,12,8,6]
    }
}

/*
nums = {1, 2, 3, 4}
answer = {1, 0, 0, 0}
prefix =>  answer[1] = answer[0] * nums[0] = 1
           answer[2] = answer[1] * nums[1] = 2
           answer[3] = answer[2] * nums[2] = 6
           {1, 1, 2, 6}

suffix => right_product = 1
          answer[3] = answer[3] * right_product = 6
                      right_product *= nums[3] = 4
          answer[2] = answer[2] * right_product = 2*4 = 8
                      right_product *= nums[2] = 12
          answer[1] = answer[1] * right_product = 1*12 = 12
                      right_product *= nums[1] = 24
          answer[0] = answer[0] * right_product = 1*24 = 24
                      right_product *= nums[0] = 24
          {24, 12, 8, 6}

 */
