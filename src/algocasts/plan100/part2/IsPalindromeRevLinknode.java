package algocasts.plan100.part2;

import java.util.Stack;

/**
 * @Author: ZYLin
 * @Date: 19-6-30 下午4:11
 */
public class IsPalindromeRevLinknode {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private static boolean isPalindromeStack(ListNode link){
        Stack<Integer> stack = new Stack<>();
        for (ListNode i = link; i != null; i = i.next){
            stack.push(link.val);
            link = link.next;
        }
        for (ListNode i = link; i != null; i = i.next){
            if (link.val == stack.pop()){
                link = link.next;
            }else {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeReverseList(ListNode head) {
        int len = 0;
        for (ListNode p = head; p != null; p = p.next, ++len);
        ListNode cur = head, pre = null;
        for (int i = 0; i < len / 2; ++i) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (len % 2 == 1) cur = cur.next;
        for (; pre != null && cur != null; pre = pre.next, cur = cur.next) {
            if (pre.val != cur.val) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode p = new ListNode(0);
        int[] i = new int[]{6,5,4,3,3,4,5,6};
        for (int a = 0; a < i.length; ++a, p = p.next){
            p.val = i[a];
            if (a != i.length - 1){
                p.next = new ListNode(0);
            }
        }
        System.out.println(isPalindromeStack(p));
        System.out.println(isPalindromeReverseList(p));
    }
}
