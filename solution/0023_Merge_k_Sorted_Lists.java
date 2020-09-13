import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Map.Entry;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode node = new ListNode(0), tmp = node;
        for (ListNode l : lists) {
            if (l != null) queue.add(l);
        }
        while (!queue.isEmpty()) {
            tmp.next = queue.poll();
            tmp = tmp.next;
            if (tmp.next != null) queue.add(tmp.next);
        }
        return node.next;
    }
}
