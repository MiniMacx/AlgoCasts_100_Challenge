package algocasts.plan100.part2;

import util.ListNode;
import util.ListNodeUtil;

/**
 * No.18 合并两个有序链表
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0), p=dummy;
        while (true){
            if (l1 == null) {
                p.next = l2;
                break;
            }
            else if (l2 == null) {
                p.next = l1;
                break;
            }
            else if (l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.genListNode(new int[]{1, 3, 5, 7});
        ListNode listNode1 = ListNodeUtil.genListNode(new int[]{2, 4, 6, 8});
        ListNode listNode2 = new MergeTwoSortedLists().mergeTwoSortedLists(listNode, listNode1);
        ListNodeUtil.print(listNode2);
    }
}
