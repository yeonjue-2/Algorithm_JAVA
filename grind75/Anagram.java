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

