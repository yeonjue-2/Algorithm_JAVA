class Anagram {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }
}

/*
Arrays.sort() -> O(nlogn)
나의 풀이는 O(n^2);

*/


// 내 풀이
public class Grain75 {
    public boolean isAnagram(String s, String t) {

        if (s.length() == t.length()) {
            for (int i = 0; i < t.length(); i++) {
                String c = String.valueOf(t.charAt(i));
                s = s.replaceFirst(String.valueOf(t.charAt(i)), "");
            }
        }

        return s.length() == 0;
    }
}

// HashTable 사용  풀이
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }
        
        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }
}

