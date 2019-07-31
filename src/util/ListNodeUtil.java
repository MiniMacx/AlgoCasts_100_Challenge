package util;

public class ListNodeUtil {
    public static ListNode genListNode(int[] a){
        if (a == null || a.length < 1) return null;
        ListNode head = new ListNode(a[0]);
        for (int i=1; i<a.length; i++){
            ListNode cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new ListNode(a[i]);
        }
        return head;
    }

    public static void print(ListNode node){
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

}
