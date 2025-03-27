// O(n), head -> 끝까지
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        return recursion(head, new HashSet<>());
    }

    private boolean recursion(ListNode head, HashSet<ListNode> set) {
        if (head == null) return false;

        if (set.contains(head)) return true;

        set.add(head);
        return recursion(head.next, set);
    }
}

// 공간 복잡도 줄이기(set x), 투 포인터
public class HasCycle2 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // 한 칸 이동
            fast = fast.next.next;  // 두 칸 이동

            if (slow == fast) {  // 만약 만나면 사이클 존재
                return true;
            }
        }
        return false;  // fast가 null에 도달하면 사이클 없음
    }
}
