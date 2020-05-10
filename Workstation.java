import java.util.*;

class Workstation {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int close = io.getInt();
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(io.getInt(), io.getInt());
        }
        Arrays.sort(arr);
        int c = 0;
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i].x > max) {
                
            }
        }
        io.println(Arrays.toString(arr));
        io.close();
    }

    static class Pair implements Comparable<Pair> {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair ot) {
            return this.x == ot.x ? this.y - ot.y : this.x - ot.x;
        }

        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }
}