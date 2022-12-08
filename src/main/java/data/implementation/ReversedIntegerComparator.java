package data.implementation;

import java.util.Comparator;

public class ReversedIntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 == null) {
            return 1;
        } else if (o2 == null) {
            return -1;
        }
        return o1.compareTo(o2) * -1;
    }
}
