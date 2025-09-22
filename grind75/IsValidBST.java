class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long min, long max) {                
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;

        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}

// 범위로 인한 실패 케이스 확인 필요!
// 처음에 min, max를 Integer로 했다가 실패함
// 문제의 범위 -2^31 <= Node.val <= 2^31 - 1 = 2147483647

/*
2147483647 node로 테스트
node.val >= max  -> false 반환 으로 실패함
값 비교에서 경계 조건이 데이터 타입의 최대/최소값에 걸릴 수 있는 경우, 한 단계 더 큰 자료형을 쓰는 게 안전한 습관!!
*/
