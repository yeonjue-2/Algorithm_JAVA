
/*
1. 큐에 시작 노드를 넣고 result map에 기존 노드 - 새로운 노드로 put
2. while 문을 큐가 비지 않을 때까지 돌면서 현재 node의 neighbors를 넣고 map의 값 node의 neighbors에 put
3. 최종 map 반환
*/

public class CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Node, Node> result = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        result.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!result.containsKey(neighbor)) {
                    queue.add(neighbor);
                    result.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                }
                result.get(cur).neighbors.add(result.get(neighbor));
            }
        }

        return result.get(node);
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
