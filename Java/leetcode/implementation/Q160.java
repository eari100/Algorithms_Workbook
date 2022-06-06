package leetcode.implementation;

/**
 * @source: https://leetcode.com/problems/intersection-of-two-linked-lists/ (160. Intersection of Two Linked Lists)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.06 (X)
 **/
public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;

        while(node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }

        return node1;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }