package list;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Find Kth to the last element => (length - k)th element
 */
public class FindKthToLast {

    public static int find(Node head, int k) {
        if (head == null) {
            return 0;
        }

        int ind = find(head.next(), k) + 1;
        if (ind == k) {
            System.out.println(k + "th = " + head.data());
        }

        return ind;
    }

    public static Node findNode(Node head, int k, AtomicInteger counter) {
        if (head == null) {
            return null;
        }

        Node node = findNode(head.next(), k, counter);
        counter.getAndIncrement();
        if (counter.get() == k) {
            return head;
        }

        return node;
    }

    public static Node findByPointer(Node head, int k) {
        Node i = head;
        Node j = head;

        for (int l = 0; l < k; l++) {
            if (i == null)
                return null;
            i = i.next();
        }

        while (i != null) {
            i = i.next();
            j = j.next();
        }

        return j;
    }


    public static void main(String[] args) {
        Node head = Node.builder().data(1)
                .next(Node.builder().data(2)
                        .next(Node.builder().data(3)
                                .next(Node.builder().data(4)
                                        .next(Node.builder().data(5)
                                                .next(Node.builder().data(6)
                                                        .build())
                                                .build())
                                        .build())
                                .build())
                        .build())
                .build();

        System.out.println(head.printForward()); // 1 --> 2 --> 3 --> 4 --> 5 --> 6

        find(head, 2); // 2th = 5
        find(head, 4); // 4th = 3
        find(head, 7); // none

        System.out.println(findNode(head, 2, new AtomicInteger()).data());
        System.out.println(findNode(head, 4, new AtomicInteger()).data());

        System.out.println(findByPointer(head, 2).data());
        System.out.println(findByPointer(head, 4).data());
    }
}
