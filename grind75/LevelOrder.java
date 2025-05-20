import java.util.*;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(list);
        }

        return result;
    }

    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int val) {
             this.val = val;
         }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20, node7, node15);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);

        System.out.println(new Solution().levelOrder(root));

        TreeNode empty = null;
        System.out.println(new Solution().levelOrder(empty));
    }
}

/*
1.큐를 하나 만든다
 - 시작점인 root 노드를 큐에 추가.
 
2. while 루프
- 큐가 비지 않는 동안 반복.
- 반복마다 현재 큐의 크기만큼만 순회해서 한 레벨의 노드들만 처리.

3.자식 노드 큐에 추가
- 현재 노드의 left, right가 존재하면 큐에 추가.

4. 리스트에 저장
- 현재 레벨의 노드 값을 리스트에 저장해서 전체 결과 리스트에 추가.
*/
