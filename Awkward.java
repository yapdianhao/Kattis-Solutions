import java.util.HashSet;

class Awkward {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = io.getInt();
        }
        if (noDup(arr)) {
            io.println(n);
        } else {
            HashSet<Integer> hs = new HashSet<>();
            int globalMax = 0;
            int bestSoFar = 0;
            for (int i : arr) {
                if (!hs.contains(i)) {
                    //io.println("here");
                    bestSoFar++;
                    hs.add(i);
                } else {
                    //io.println("there");
                    //hs.remove(i);
                    //hs.add(i);
                    globalMax = Math.max(globalMax, bestSoFar);
                    bestSoFar = globalMax - 1;
                }
                io.println(globalMax + " " + bestSoFar);
                //io.println(hs);
            }
            globalMax = Math.max(globalMax, bestSoFar);
            io.println(globalMax);
        }
        io.close();
    }

    static boolean noDup(int[] arr) {
        HashSet<Integer> h = new HashSet<Integer>();
        for (int i : arr) {
            if (!h.contains(i)) h.add(i);
        }
        return h.size() == arr.length;
    }
}