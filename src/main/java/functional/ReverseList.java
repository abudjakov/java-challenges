package functional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseList {

    public static void main(String[] args) {

        List<Integer> list = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());

//        System.out.println(CollectionUtils.foldLeft(list, "0", x -> y -> "(" + x + " + " + y + ")"));
//        System.out.println(CollectionUtils.foldRight(list, "0", x -> y -> "(" + y + " + " + x + ")"));
//        System.out.println(CollectionUtils.foldRight(list, "0", x -> y -> "(" + x + " + " + y + ")"));
        System.out.println(CollectionUtils.reverse(list));

//        (0 + (1 + (2 + (3 + (4 + (5))))))
    }

}
