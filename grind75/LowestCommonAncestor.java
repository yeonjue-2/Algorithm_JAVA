/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 모든 트리에서 사용가능 O(n)
class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
}

// 이진 탐색 트리로 개선 O(log n)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int nodeVal = root.val;

        if(p.val < nodeVal && q.val < nodeVal) {
            return lowestCommonAncestor(root.left, p, q);   // 둘 다 왼쪽 서브트리에 있음
        } else if(p.val > nodeVal && q.val > nodeVal) {
            return lowestCommonAncestor(root.right, p, q);  // 둘 다 오른쪽 서브트리에 있음
        }
        return root;
    }
}
