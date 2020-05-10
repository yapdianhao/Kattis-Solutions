import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Akcija {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int price = 0;
        int books = io.getInt();
        int[] arr = new int[books];
        for (int i = 0; i < books; i++) {
            arr[i] = io.getInt();
        }
        int[] copy = new int[books];
        Arrays.sort(arr);
        for (int i = 0; i < books; i++) {
            copy[i] = arr[arr.length - i - 1];
        }
        for (int i = 0; i < books; i++) {
            if (i % 3 == 2) continue;
            price += copy[i];
        }
        io.println(price);
        io.close();
    }
}