package leet;

import util.ListNode;
import util.ListNodeUtil;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AddTwoNumber {

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int o; //进位
//        ListNode n = new ListNode(first);
//        while (sum > 0){
//            ListNode cur = n;
//            while (cur.next != null){
//                cur = cur.next;
//            }
//            cur.next = new ListNode((int)sum%10);
//            sum /= 10;
//        }
//        return n;
//    }

    private static long sumNode(ListNode l2, long i2) {
        for (int i = 0; l2 != null; i++, l2 = l2.next) {
            i2 += l2.val * (int) Math.pow(10d, (double) i);
        }
        return i2;
    }

    public static void main(String[] args) {
        ListNode n = ListNodeUtil.genListNode(new int[]{1,9,9,9,9,9,9,9,9,9});
        ListNode n2 = ListNodeUtil.genListNode(new int[]{9});
////        ListNode listNode = addTwoNumbers(n, n2);
//        while (listNode != null){
//            System.out.print(listNode.val + "  ");
//            listNode = listNode.next;
//        }
    }
}
