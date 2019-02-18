package list;

public class Partition {

    public static Node partition(Node node, int x) {
        Node head = node;
        Node tail = node;

        while (node != null) {
            Node next = node.next();
            if (node.data() < x) {
                node.next(head);
                head = node;
            } else {
                tail.next(node);
                tail = node;
            }
            node = next;
        }
        tail.next(null);

        return head;
    }

    public static void main(String[] args) {
        Node head = Node.build(3, 5, 8, 5, 10, 2, 1);

        System.out.println("before: " + head.printForward());

        System.out.println("after: " + partition(head, 5).printForward());
    }
}
