package SORTING;

import java.util.Arrays;
import java.util.Comparator;

public class bubble {
    static <E> void sort(E arr[], Comparator<? super E> c) {

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (c == null) {
                    Comparable<? super E> k = ((Comparable<? super E>) arr[j]);
                    if (k.compareTo(arr[j + 1]) > 0) {
                        E t = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = t;
                    }
                } else {
                    int k = c.compare((E) arr[j], (E) arr[j + 1]);
                    if (k > 0) {
                        E t = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = t;
                    }

                }

            }
        }
    }

    public static void main(String[] args) {
        Integer arr[] = {100, 200, 500, 700, 900, -9, -7, -5, -2, 0, 4, 7, 2, 4};
        String se[] = {"nguyen", "le", "tt", "aa", "bb", "cc"};
        sort(se, (a, b) -> b.compareTo(a));
        for (String s : se
        ) {
            System.out.print(s + " ");
        }
    }
}
