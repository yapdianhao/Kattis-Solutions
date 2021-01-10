import java.util.*;

class Tower {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int pieces = io.getInt();
        int[] arr = new int[pieces];
        for (int i = 0; i < pieces; i++) {
            arr[i] = io.getInt();
        }
        int towers = 1;
        int curr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > curr) {
                towers++;
            }
            curr = arr[i];
        }
        io.println(towers);
        io.close();
    }
}