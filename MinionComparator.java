import java.util.*;

class MinionComparator implements Comparator<Minion> {

    public int compare(Minion m1, Minion m2) {
        if (m1.low < m2.high) {
            return -1;
        } else {
            return 1;
        }
    }
}