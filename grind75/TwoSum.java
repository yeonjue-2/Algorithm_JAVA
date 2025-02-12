class TwoSum {
    public int[] twoSum(int[] nums, int target) {

      Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {                
            int complement = target - nums[i];                 

            if (numMap.containsKey(complement)) {              
                return new int[]{numMap.get(complement), i};                  
            }

            numMap.put(nums[i], i);                            
        }
        return new int[]{};
    }
}


// class Solution {
//     public int[] twoSum(int[] nums, int target) {

//       int sum = 0;

//       for (int i = 0; i < nums.length - 1; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 sum = nums[i] + nums[j];

//                 if (sum == target) {
//                     return new int[]{i, j};
//                 }
//             }
//         }
//         return null;
//     }
// }
