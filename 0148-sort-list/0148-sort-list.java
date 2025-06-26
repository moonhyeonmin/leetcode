
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static ListNode deserialize(String data) {
        if (data == null || data.trim().isEmpty() || data.equals("[]")) {
            return null;
        }
        
        // "[1,2,3,4]" 형태의 문자열을 처리
        data = data.trim();
        if (data.startsWith("[") && data.endsWith("]")) {
            data = data.substring(1, data.length() - 1);
        }
        
        if (data.isEmpty()) {
            return null;
        }
        
        String[] values = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for (String val : values) {
            val = val.trim();
            if (!val.isEmpty()) {
                current.next = new ListNode(Integer.parseInt(val));
                current = current.next;
            }
        }
        
        return dummy.next;
    }
 }
 
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode half = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        half.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge_list(l1, l2);
    }

    public ListNode merge_list(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val > l2.val) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }

        l1.next = merge_list(l1.next, l2);
        return l1;
    }
}