package list;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class SumLists {

    public static Node sumReversedOrder(Node a, Node b) {
        return sumReversedOrder(a, b, 0);
    }

    public static Node sumReversedOrder(Node a, Node b, int carry) {
        if (a == null && b == null && carry == 0) {
            return null;
        }

        Node r = new Node();
        int value = carry;
        if (a != null) {
            value += a.data();
        }

        if (b != null) {
            value += b.data();
        }

        r.data(value % 10);

        if (a != null || b != null) {
            Node next = sumReversedOrder(a == null ? null : a.next(), b == null ? null : b.next(), value >= 10 ? 1 : 0);
            r.next(next);
        }

        return r;
    }

    public static void checkReversedOrder() {
        System.out.println("checkReversedOrder");
        Node a = Node.build(7, 1, 6);
        Node b = Node.build(5, 9, 2);

        // 7 -> 1 -> 6 (617)
        // 5 -> 9 -> 2 (295)
        // 2 -> 1 -> 9 (912)

        Node r = sumReversedOrder(a, b);
        System.out.println("sum: " + r.printForward()); // 912

        a = Node.build(7, 1, 6);
        b = Node.build(5, 9);
        System.out.println("sum: " + sumReversedOrder(a, b).printForward()); // 712
    }


    @Setter
    @Getter
    @Accessors(fluent = true)
    public static class SumNode {
        private Node node;
        private int carry;
    }

    public static SumNode sum(Node a, Node b) {
        if (a == null && b == null) {
            return new SumNode();
        }

        SumNode sumNode = sum(a.next(), b.next());
        int value = a.data() + b.data() + sumNode.carry();

        Node node = addLeft(sumNode.node(), value % 10);
        sumNode.node(node);
        sumNode.carry(value / 10);

        return sumNode;
    }

    public static Node sumForwardOrder(Node a, Node b) {
        int lengthA = length(a);
        int lengthB = length(b);

        if (lengthA > lengthB) {
            b = padLeft(b, lengthA - lengthB);
        } else if (lengthB > lengthA) {
            a = padLeft(a, lengthB - lengthA);
        }

        SumNode sumNode = sum(a, b);

        return sumNode.carry == 0 ? sumNode.node : addLeft(sumNode.node, sumNode.carry);
    }

    public static Node padLeft(Node head, int padding) {
        Node node = head;
        for (int i = 0; i < padding; i++) {
            node = addLeft(node, 0);
        }
        return node;
    }

    public static Node addLeft(Node head, int data) {
        return Node.builder().data(data).next(head).build();
    }

    public static int length(Node node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next();
        }
        return length;
    }

    public static void checkForwardOrder() {
        System.out.println("checkForwardOrder");
        Node a = Node.build(6, 1, 7);
        Node b = Node.build(2, 9, 5);

        System.out.println("sum: " + sumForwardOrder(a, b).printForward()); // 912

        a = Node.build(6, 1, 7);
        b = Node.build(9, 5);
        System.out.println("sum: " + sumForwardOrder(a, b).printForward()); // 712
    }

    public static void main(String[] args) {
        checkReversedOrder();
        checkForwardOrder();
    }
}
