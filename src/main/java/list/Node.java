package list;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Builder(toBuilder = true)
@Accessors(fluent = true)
public class Node {

    private int data;
    private Node next;

    public String printForward() {
        if (next != null)
            return data + " --> " + next.printForward();
        else
            return String.valueOf(data);
    }
}
