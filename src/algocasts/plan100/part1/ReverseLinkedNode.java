package algocasts.plan100.part1;

/**
 * No.9 反转单链表
 * @author Lin
 */
public class ReverseLinkedNode {

    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * Time: O(n), Space: O(1)
     * @param head
     * @return
     */
    public static Node reverse(Node head){
        Node cur = head, pre = null;
        while (cur != null) {
            //1.保存cur节点的next引用
            Node next = cur.next;
            //2.cur节点的next指向pre
            cur.next = pre;
            //3.pre节点指向cur
            pre = cur;
            //4.cur节点变成了原next节点,同时指针发生了翻转
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        int i = 0;
        while (i < 5){
            Node n = new Node(i);
            n.next = head.next;
            head.next = n;
            i++;
        }
        Node rnode = reverse(head);
        while (rnode.next != null) {
            System.out.println(rnode.value);
            rnode = rnode.next;
        }
    }
}
