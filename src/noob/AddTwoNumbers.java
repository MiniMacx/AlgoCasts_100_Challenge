package noob;

import java.util.List;

public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(4);
        new AddTwoNumbers().addTwoNumbers(l1,l2);
    }

    /**
     * 自己写的
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        int sum;
        ListNode resNode = null, r = null;
        while (l1 != null || l2 != null) {
            //可做成三目,一个公式解决
            if (l1 == null) {
                sum = l2.val + temp;
            }
            else if (l2 == null) {
                sum = l1.val + temp;
            }
            else {
                sum = l1.val + l2.val + temp;
            }
            //temp = sum/10
            if (temp > 0) {
                --temp;
            }
            if (sum >= 10) {
                ++temp;
                sum -= 10;
            }
            //sum = sum % 10;
            if (null == resNode) {
                resNode = new ListNode(sum);
                r = resNode;
            }else {
                ListNode node = new ListNode(sum);
                r.next = node;
//                node.next = resNode.next;
                r = node;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //不需要尾指针，用dummyhead后resNode = resNode.next即可到达下一个位置
        if (temp == 1) {
            ListNode node = new ListNode(1);
            r.next = node;
            r = node;
        }
        return resNode;
    }

    /**
     * 别人写的
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersGreater(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
