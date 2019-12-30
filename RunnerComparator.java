import java.util.*;

class RunnerComparator implements Comparator<Runner> {
    
    public int compare(Runner r1, Runner r2) {
        if (r1.otherLap < r2.otherLap) {
            return -1;
        } else {
            return 1;
        }
    }
}