public class LengthOfLongestSubstring {

  // 개선되지 않은 메서드
  // O(n^2)가 걸릴 수 있음 (substring과 contains)
    public int lengthOfLongestSubstring(String s) {
        List<String> str = Arrays.asList(s.split(""));
        System.out.println(str.size());
        int result = 0;
        int start = 0;
        int end = start + 1;

        while (end < str.size()) {
            String sub = s.substring(start, end);
            if (!sub.contains(str.get(end))) {
                end++;
            } else {
                start = end + 1;
                end = start + 1;
            }
            result = Math.max(result, end-start);
        }
        return result;
    }

  // 개선안, O(n)
  public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
  
}
