package hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;

public class MergeSortedLinkedLists {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    public static void main(String[] args) {

    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        SinglyLinkedListNode head3 = null;

        if (head1.data < head2.data) {
            head3 = head1;
            head1 = head1.next;
        } else {
            head3 = head2;
            head2 = head2.next;
        }

        SinglyLinkedListNode currentNode = head3;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                currentNode.next = head1;
                head1 = head1.next;
            } else {
                currentNode.next = head2;
                head2 = head2.next;
            }
            currentNode = currentNode.next;
        }

        if (head1 == null) {
            currentNode.next = head2;
        } else {
            currentNode.next = head1;
        }

        return head3;
    }
}
