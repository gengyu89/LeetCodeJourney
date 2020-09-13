/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow, fast, curr;
        slow = head; fast = head;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        // n == len
        if (fast == null) {
            head = head.next;
            return head;
        }
        // Move both pointers, until reach tail
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        curr = slow.next;
        slow.next = curr.next;
        return head;
    }
}
