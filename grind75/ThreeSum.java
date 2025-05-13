class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // i 중복 제거

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // [-1, -1, 2], [-1, -1, 2] 방지를 위한 중복 제거
                    while (left < right && nums[left] == nums[left + 1])   left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
/*
정렬 + 고정 + 투포인터
1. 정렬
중복 제거와 투포인터 활용을 위해 배열을 정렬함.

2. 하나의 값 고정 (i)
인덱스 i를 기준으로 앞에서부터 순차적으로 하나씩 고정.

3. 투포인터 (left, right)
고정된 i 다음 인덱스를 left, 끝 인덱스를 right로 놓고
nums[i] + nums[left] + nums[right] == 0인 조합을 찾음.

4. 중복 제거
i에 대해 같은 값이면 continue.
left, right가 가리키는 값이 중복되면 건너뜀.
 */
