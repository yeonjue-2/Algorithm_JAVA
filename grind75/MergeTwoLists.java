class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummyHead = null;

        if (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dummyHead = new ListNode(list1.val);
                dummyHead.next = mergeTwoLists(list1.next, list2);
            } else {
                dummyHead = new ListNode(list2.val);
                dummyHead.next = mergeTwoLists(list2.next, list1);
            }
        } else if (list1 != null) {
            dummyHead = new ListNode(list1.val);
            dummyHead.next = mergeTwoLists(list1.next, list2);
        } else if (list2 != null) {
            dummyHead = new ListNode(list2.val);
            dummyHead.next = mergeTwoLists(list2.next, list1);
        } else {
            return dummyHead;
        }

        return dummyHead;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {

        Grain75 sol = new Grain75();
        ListNode s = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode s1 = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println(sol.mergeTwoLists(s, s1).toString());
    }
}

//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//Example 2:
