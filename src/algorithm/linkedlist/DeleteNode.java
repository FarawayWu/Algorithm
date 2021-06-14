package algorithm.linkedlist;

import com.company.DataHelperInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * eg 1 :
 *      输入：head = [1,2,6,3,4,5,6], val = 6
 *      输出：[1,2,3,4,5]
 *
 * eg2 :
 *     输入：head = [], val = 1
 *     输出：[]
 *
 * eg3:
 *    输入：head = [7,7,7,7], val = 7
 *    输出：[]
 *
 * 提示：
 * 列表中的节点在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 */

public class DeleteNode implements DataHelperInterface<DeleteNode.ListNode>{
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(){

        }
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(ListNode next, int val) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * newHead for first valid node of the head;
     * lastNode for every valid node;
     * @param head
     * @param val
     * @return
     */
    private ListNode removeElements(ListNode head, int val) {
        ListNode newHead = null;
        ListNode lastNode = null;
        for(ListNode next = head; next != null; next = next.next) {
            if(next.val == val) {
                if(lastNode != null) {
                    lastNode.next = null;
                }
            } else{
                if(newHead == null) {
                    newHead = next;
                }
                if(lastNode != null) {
                    lastNode.next = next;
                }
                lastNode = next;
            }
        }
        return newHead;
    }

    /**
     * build a virtual first node;
     * 相较于自己的方法，少开辟一个cur node空间
     * @param head
     * @param val
     * @return
     */
    private ListNode removeElements_build_node(ListNode head, int val) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode cur = newHead;
        while (cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    /**
     * 递归
     * 链表的定义具备递归的性质。
     * 可以这样理解：n个节点，每次仅处理head
     *            if (head == null) return;
     *            else if head.val == deleteVal return head.next;
     *            else if head.val != deleteVal return head;
     * @param head
     * @param val
     * @return
     */
    private ListNode removeElements_recursion(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    @Override
    public ListNode prepareInput() {
        ListNode listNode_1 = new ListNode(1);
        ListNode listNode_2 = new ListNode(2);
        ListNode listNode_3 = new ListNode(6);
        ListNode listNode_4 = new ListNode(3);
        ListNode listNode_5 = new ListNode(4);
        ListNode listNode_6 = new ListNode(5);
        ListNode listNode_7 = new ListNode(6);
        listNode_1.next = listNode_2;
        listNode_2.next = listNode_3;
        listNode_3.next = listNode_4;
        listNode_4.next = listNode_5;
        listNode_5.next = listNode_6;
        listNode_6.next = listNode_7;
        return listNode_1;
    }

    @Override
    public void startOutput() {
        ListNode node = removeElements_recursion(prepareInput(), 6);
        List<Integer> list = new ArrayList<>();
        for(ListNode cur = node; cur != null; cur = cur.next) {
            list.add(cur.val);
        }
        System.out.println(list.toString());
    }
}
