public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        Map<Character, Integer> magazineMap = new HashMap<>();
        Map<Character, Integer> noteMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char key = magazine.charAt(i);
            magazineMap.put(key, magazineMap.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char key = ransomNote.charAt(i);
            noteMap.put(key, noteMap.getOrDefault(key, 0) + 1);
        }

        for (Character key : noteMap.keySet()) {
            int required = noteMap.get(key);
            int available = magazineMap.getOrDefault(key, 0);

            if (available < required) {
                return false;
            }
        }

        return true;
    }

    // 속도 개선 버전
     public boolean canConstruct2(String ransomNote, String magazine) {
          int[] note = new int[26];
          int[] mgz = new int[26];
  
          for (char c : ransomNote.toCharArray()) {
              note[c - 'a']++;
          }
  
          for (char c : magazine.toCharArray()) {
              mgz[c - 'a']++;
          }
  
          for (int i = 0; i < note.length; i++) {
              if (note[i] > mgz[i]) return false;
          }
  
          return true;
      }
}
