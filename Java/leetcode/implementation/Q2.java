package leetcode.implementation;

/**
 * @source: https://leetcode.com/problems/add-two-numbers/ (2. Add Two Numbers)
 * @classfication: implementation
 * @performance: Runtime: 1ms, 100% / Memory: 43.27MB, 56.10%
 * @문제 푼 날짜 (자력으로 풂?): 23.08.30 (O)
 **/
public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sumNodes(l1, l2, 0);
    }

    private ListNode sumNodes(ListNode l1, ListNode l2, int add) {
        ListNode currNode;
        int l1Val = 0, l2Val = 0;

        if(l1 != null) {
            l1Val = l1.val;
        }

        if(l2 != null) {
            l2Val = l2.val;
        }

        int sum1 = l1Val + l2Val + add;
        int nextAdd = 0;
        int sum2 = 0;

        if(sum1 >= 10) {
            sum2 = sum1 - 10;
            nextAdd = 1;
        } else {
            sum2 = sum1;
        }

        ListNode nextL1 = null, nextL2 = null;

        if(l1 != null && l1.next != null) {
            nextL1 = l1.next;
        }

        if(l2 != null && l2.next != null) {
            nextL2 = l2.next;
        }

        if(nextL1 == null && nextL2 ==null && nextAdd == 0) {
            return new ListNode(sum2);
        } else {
            return new ListNode(sum2, sumNodes(nextL1, nextL2, nextAdd));
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}