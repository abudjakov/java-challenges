package functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

public class CollectionUtils {

    public static <T> List<T> list() {
        return Collections.emptyList();
    }

    public static <T> List<T> list(T element) {
        return Collections.singletonList(element);
    }

    public static <T> List<T> copy(List<T> list) {
        return unmodifiableList(new ArrayList<T>(list));
    }

    public static <T> List<T> append(List<T> list, T element) {
        List<T> result = new ArrayList<>(list);
        result.add(element);
        return unmodifiableList(result);
    }

    public static <T> List<T> prepend(List<T> list, T element) {
        return foldLeft(list, list(element), x -> y -> append(x, y));
    }

    public static <T, U> U foldLeft(List<T> list, U identity, Function<U, Function<T, U>> f) {
        U result = identity;
        for (T t : list) {
            result = f.apply(result).apply(t);
        }
        return result;
    }

    public static <T, U> U foldRight(List<T> ts, U identity, Function<T, Function<U, U>> f) {
        U result = identity;
        for (int i = ts.size(); i > 0; i--) {
            result = f.apply(ts.get(i - 1)).apply(result);
        }
        return result;
    }

    public static <T> List<T> reverse(List<T> list) {
        return foldLeft(list, emptyList(), x -> y -> prepend(x, y));
    }
}
