package tasktwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AppTwo {

    public static void main(String[] args) {

        String array[] = {"one", "two", "three", "four"};
        List<String> listElements = new ArrayList<>();

        System.out.println(Arrays.deepToString(array));

        System.out.println("Array convert to collection");
        System.out.println(ArrayToCollection(array, listElements));

    }

    public static <T> Collection<T> ArrayToCollection(T[] array, Collection<T> collection) {
        for (T elem : array) {
            collection.add(elem);
        }
        return collection;
    }
}
