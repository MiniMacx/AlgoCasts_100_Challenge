package algocasts.plan100.part2;

import com.sun.org.apache.xalan.internal.xsltc.NodeIterator;

import java.util.Stack;

/**
 * No.17 带有min函数的栈
 */
public class MinStack {
    class MinStackWithStack{
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> min = new Stack<>();

        public void push(Integer i){
            stack.push(i);
            if (min.isEmpty() || getMin() > i) min.push(i);
        }

        public void pop(){
            if (stack.peek() == getMin()) min.pop();
            stack.pop();
        }

        public int top(){
            return stack.peek();
        }

        public int getMin(){
            return min.peek();
        }
    }

    class MinStackWithListNode{
        private class ListNode{
            int val;
            ListNode next;
            public ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
        private int min = Integer.MAX_VALUE;
        private ListNode head = null;

        public void push(Integer i){
            if (min > i) {
                head = new ListNode(min, head);
                min = i;

            }
            head = new ListNode(i, head);
        }

        public void pop(){
            if (min == head.val){
                min = head.next.val;
                head = head.next.next;
            }else {
                head = head.next;
            }
        }

        public int top(){
            return head.val;
        }

        public int getMin(){
            return min;
        }
    }
}
