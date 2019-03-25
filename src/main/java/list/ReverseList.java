package list;

public class ReverseList {

    public static Node reverse(Node node) {
        Node prev = null;
        Node next;
        while (node != null) {
            next = node.next();
            node.next(prev);
            prev = node;
            node = next;
        }
        return prev;
    }

    public static Node reverse(Node node, Node prev) {
        if (node.next() == null) {
            return node.next(prev);
        }

        Node head = reverse(node.next(), node);
        node.next(prev);

        return head;
    }

    public static void main(String[] args) {
        Node node = Node.build(1, 2, 3, 4, 5);
        System.out.println("before: " + node.printForward());
//        System.out.println("after: " + reverse(node).printForward());
        System.out.println("after: " + reverse(node, null).printForward());
    }
}
