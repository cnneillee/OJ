package cn.neillee.base;

public class DoublyListNode {
    public int val;
    public DoublyListNode next, prev;

    public DoublyListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }

    public static void print(DoublyListNode node) {
        if (node == null) return;
        System.out.print(node.val + "，");
        print(node.next);
    }

    public DoublyListNode getHead() {
        if (this.prev == null) return this;
        else return this.prev.getHead();
    }

    public DoublyListNode getTail() {
        if (this.next == null) return this;
        else return this.next.getTail();
    }
}