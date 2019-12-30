import java.util.List;
import java.util.ArrayList;

class Parket {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int R = io.getInt();
        int B = io.getInt();
        int sum =(int) (4 + R) / 2;
        int mult = R + B;
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= mult; i++) {
            if (mult % i == 0) factors.add(i);
        }
        int[] arr = new int[factors.size()];
        for (int i = 0; i < factors.size(); i++) {
            arr[i] = factors.get(i);
        }
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            if (arr[lo] + arr[hi] > sum) {
                lo++;
                hi--;
            } else if (arr[lo] + arr[hi] == sum) {
                io.println(arr[hi] + " " + arr[lo]);
                break;
            }
        }
        io.close();
    }
}