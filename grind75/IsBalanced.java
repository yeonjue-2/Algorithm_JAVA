/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;  // 왼쪽 서브트리가 불균형이면 바로 종료

        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1;  // 오른쪽 서브트리가 불균형이면 바로 종료

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;  // 높이 차이가 1 초과면 불균형

        return Math.max(leftHeight, rightHeight) + 1;  // 현재 노드의 높이 반환
    }
}
