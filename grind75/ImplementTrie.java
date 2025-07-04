class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        this.isEndOfWord = false;
    }
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;  // 끝에 도달했으니 true 설정
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) return false;  // 없으면 등록된 단어가 아님
            current = current.children.get(ch);
        }
        return current.isEndOfWord;  // 끝에 도달했다면 존재하는 단어
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) return false;  // 없으면 등록된 단어가 아님
            current = current.children.get(ch);
        }
        return true;
    }
}
