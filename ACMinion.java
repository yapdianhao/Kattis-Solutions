import java.util.*;

class ACMinion {

    static Kattio io = new Kattio(System.in);
    static int count = 1;

    public static void main(String[] args) {
        int minions = io.getInt();
        Pair[] arr = new Pair[minions];
        for (int i = 0; i < minions; i++) {
            arr[i] = new Pair(io.getInt(), io.getInt());
        }
        Arrays.sort(arr);
        int max = arr[0].end;
        for (int i = 1; i < minions; i++) {
            if (arr[i].start > max) {
                count++;
                max = arr[i].end;
            }
        }
        io.println(count);
        io.close();
    }

    static class Pair implements Comparable<Pair> {

        int start;
        int end;

        public Pair(int s, int e) {
            this.start = s;
            this.end = e;
        }

        public int compareTo(Pair ot) {
            return this.end != ot.end ? this.end - ot.end : this.start - ot.start;
        }
    }
}