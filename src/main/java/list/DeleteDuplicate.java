package list;

public class DeleteDuplicate {

    public static void delete(Node head) {
        Node current = head;
        while (current != null) {
            Node it = current;
            while (it.next() != null) {
                if (it.next().data() == current.data()) {
                    it.next(it.next().next());
                } else {
                    it = it.next();
                }
            }
            current = current.next();
        }
    }

    public static void main(String[] args) {
        Node head = Node.builder().data(2)
                .next(Node.builder().data(3)
                        .next(Node.builder().data(4)
                                .next(Node.builder().data(3)
                                        .next(Node.builder().data(5)
                                                .build())
                                        .build())
                                .build())
                        .build())
                .build();

        System.out.println("before:\t" + head.printForward()); // 2 --> 3 --> 4 --> 3 --> 5
        delete(head);
        System.out.println("after:\t" + head.printForward());
        assert head.printForward().equals("2 --> 3 --> 4 --> 5");
    }
}
