
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    // 로컬 테스트용 deserialize 메서드
    public static ListNode deserialize(String data) {
        if (data == null || data.equals("[]")) return null;
        
        // "[1,2,3,4,5]" 형태의 문자열을 파싱
        data = data.substring(1, data.length() - 1); // 대괄호 제거
        if (data.isEmpty()) return null;
        
        String[] vals = data.split(",");
        ListNode head = new ListNode(Integer.parseInt(vals[0].trim()));
        ListNode current = head;
        
        for (int i = 1; i < vals.length; i++) {
            current.next = new ListNode(Integer.parseInt(vals[i].trim()));
            current = current.next;
        }
        
        return head;
    }
 }

class Solution {
    
    public ListNode insertionSortList(ListNode head) {
        ListNode parent = new ListNode();
        ListNode p = parent;

        while (head != null) {
            while (p.next != null && p.next.val < head.val) {
                p = p.next;
            }

            ListNode pNext = p.next;
            ListNode headNext = head.next;
            p.next = head;
            head.next = pNext;
            head = headNext;
            p = parent;
        }

        return parent.next;
    }
}