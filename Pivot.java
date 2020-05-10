import java.util.*;

class Pivot {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = io.getInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (check(arr, i)) count++;
        }
        io.println(count);
        io.close();
    }

    static boolean check(int[] arr, int idx) {
        for (int i = 0; i < idx; i++) {
            if (arr[i] > arr[idx]) return false;
        }
        for (int i = idx + 1; i < arr.length; i++) {
            if (arr[i] < arr[idx]) return false;
        }
        return true;
    }
}