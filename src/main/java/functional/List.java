package functional;

import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public abstract class List<A> {

    private static final List NIL = new Nil();

    public static <A> List<A> list() {
        return NIL;
    }

    public static <A> List<A> list(A... args) {
        List<A> list = list();
        for (int i = args.length - 1; i >= 0; i--) {
            list = new Node<A>(args[i], list);
        }
        return list;
    }

    public static <A> List<A> concat(List<A> list1, List<A> list2) {
        return list1.isEmpty()
                ? list2
                : new Node<>(list1.head(), concat(list1.tail(), list2));
    }

    public static Integer sum(List<Integer> list) {
        return list.isEmpty()
                ? 0
                : list.head() + sum(list.tail());
    }

    public static void main(String[] args) {
       /* List<Integer> list = list(1, 2, 3, 4, 5, 6);
        System.out.println(list);
        System.out.println(sum(list));
        System.out.println(list.foldLeft(0, x -> y -> x + y));
        System.out.println(list.foldRight(0, x -> y -> x + y));

        List<Integer> list2 = list(10, 11, 12, 13, 14, 15);
        List<Integer> list3 = concat(list, list2);

        System.out.println(list3);

        System.out.println(list3.reverse());

        System.out.println(list3.removeLast().removeLast());*/

    }

    public abstract A head();

    public abstract List<A> tail();

    public abstract boolean isEmpty();

    public abstract List<A> head(A head);

    public abstract String toString();

    public abstract List<A> reverse();

    public abstract List<A> removeLast();

    public abstract <B> B foldLeft(B identity, Function<B, Function<A, B>> f);

    public abstract <B> B foldRight(B identity, Function<A, Function<B, B>> f);

    private static class Nil<A> extends List<A> {
        @Override
        public A head() {
            throw new IllegalStateException("head called at empty list");
        }

        @Override
        public List<A> tail() {
            throw new IllegalStateException("tail called at empty list");
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public List<A> head(A head) {
            throw new IllegalStateException("head raplacemnet called at empty list");
        }

        @Override
        public String toString() {
            return "NIL";
        }

        @Override
        public List<A> reverse() {
            return this;
        }

        @Override
        public List<A> removeLast() {
            throw new IllegalStateException("removeLast called at empty list");
        }

        @Override
        public <B> B foldLeft(B identity, Function<B, Function<A, B>> f) {
            return identity;
        }

        @Override
        public <B> B foldRight(B identity, Function<A, Function<B, B>> f) {
            return identity;
        }
    }

    private static class Node<A> extends List<A> {

        private final A head;
        private final List<A> tail;

        public Node(A head, List<A> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public A head() {
            return head;
        }

        @Override
        public List<A> tail() {
            return tail;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public List<A> head(A head) {
            return new Node<A>(head, tail());
        }

        @Override
        public String toString() {
            return String.format("[%s]", toString(new StringBuilder(), this).eval());
        }

        private TailCall<StringBuilder> toString(StringBuilder acc, List<A> list) {
            return list.isEmpty()
                    ? TailCall.result(acc.append("Nil"))
                    : TailCall.suspend(() -> toString(acc.append(list.head()).append(", "), list.tail()));
        }

        @Override
        public List<A> reverse() {
            return reverse_(list(), this).eval();
        }

        private TailCall<List<A>> reverse_(List<A> acc, List<A> list) {
            return list.isEmpty()
                    ? TailCall.result(acc)
                    : TailCall.suspend(() -> reverse_(new Node<A>(list.head(), acc), list.tail()));
        }

        @Override
        public List<A> removeLast() {
            return reverse().tail().reverse();
        }

        @Override
        public <B> B foldLeft(B identity, Function<B, Function<A, B>> f) {
            return foldLeft_(this, identity, f);
        }

        private <B> B foldLeft_(List<A> list, B acc, Function<B, Function<A, B>> f) {
            return list.isEmpty()
                    ? acc
                    : foldLeft_(list.tail(), f.apply(acc).apply(list.head()), f);
        }

        @Override
        public <B> B foldRight(B identity, Function<A, Function<B, B>> f) {
            return foldRight_(this, identity, f);
        }

        private <B> B foldRight_(List<A> list, B acc, Function<A, Function<B, B>> f) {
            return list.isEmpty()
                    ? acc
                    : f.apply(list.head()).apply(foldRight_(list.tail(), acc, f));
        }

    }
}
