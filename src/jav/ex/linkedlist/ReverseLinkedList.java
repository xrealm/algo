package jav.ex.linkedlist;

import jav.base.Node;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node first = new Node();
        Node last = first;
        Node node = null;
        for (int i = 1; i < 10; i++) {
            node = new Node();
            node.value = i;
            last.next = node;
            last = node;
        }

        Node cur = reverseList(first);
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }

    private static Node reverseList(Node head) {
        if (head == null) {
            return head;
        }
        //当前节点
        Node node = head;
        //保存上一个节点，防断链
        Node preNode = null;
        //新的头
        Node reverseHead = null;
        while (node != null) {
            Node nextNode = node.next;
            node.next = preNode;
            preNode = node;
            if (nextNode == null) {
                reverseHead = node;
            }
            node = nextNode;
        }

//        while (reverseHead != null) {
//            System.out.println(reverseHead.value);
//            reverseHead = reverseHead.next;
//        }

        return reverseHead;
    }
}
