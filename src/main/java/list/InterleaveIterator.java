package list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class InterleaveIterator {

    public static <E> Iterator<E> interleave(List<Iterator<E>> iterators) {
        return new Iterator<E>() {

            int cursor;

            @Override
            public boolean hasNext() {
                return iterators.stream().anyMatch(Iterator::hasNext);
            }

            @Override
            public E next() {
                int i = 0;
                int size = iterators.size();
                while (i++ < size) {
                    Iterator<E> it = iterators.get((size + cursor++) % size);
                    if (it.hasNext())
                        return it.next();
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static void main(String[] args) {
        List<String> a = Arrays.asList("a".split(""));
        List<String> b = Arrays.asList("123".split(""));
        List<String> c = Arrays.asList("x".split(""));
        Iterator<String> iterator = interleave(Arrays.asList(a.iterator(), b.iterator(), c.iterator()));

        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
