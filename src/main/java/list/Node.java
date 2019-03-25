package list;

import lombok.*;
import lombok.experimental.Accessors;

@Setter
@Getter
@Builder(toBuilder = true)
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Node {

    private int data;
    private Node next;

    public String printForward() {
        if (next != null)
            return data + " --> " + next.printForward();
        else
            return String.valueOf(data) + " --> NULL";
    }

    public static Node build(int... data) {
        if (data.length == 0) {
            return null;
        }

        Node head = Node.builder().data(data[0]).build();
        Node node = head;
        for (int i = 1; i < data.length; i++) {
            node.next(Node.builder().data(data[i]).build());
            node = node.next();
        }
        return head;
    }
}
