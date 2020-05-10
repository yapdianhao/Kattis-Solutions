import java.util.*;

class Sync {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int curr = io.getInt();
        while (curr != 0) {
            solve(io, curr);
            io.println();
            curr = io.getInt();
        }
        io.close();
    }

    static void solve(Kattio io, int nums) {
        int[] A = new int[nums];
        int[] C = new int[nums];
        int[] B = new int[nums];
        for (int i = 0; i < nums; i++) {
            A[i] = C[i] = io.getInt();
        }
        for (int i = 0; i < nums; i++) {
            B[i] = io.getInt();
        }
        Arrays.sort(A);
        Arrays.sort(B);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums; i++) {
            map.put(A[i], B[i]);
        }
        for (int i = 0; i < nums; i++) {
            int mapped = map.get(C[i]);
            io.println(mapped);
        }
    }
}