import java.util.*;

class Mario {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int range = sc.nextInt();
        int obstacles = sc.nextInt();
        int[] arr = new int[obstacles];
        for (int i = 0; i < obstacles; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < range; i++) {
            if (contains(arr, i)) {
                count++;
                continue;
            } else {
                System.out.println(i);
            }
        }
        System.out.println(String.format("Mario got %d of the dangerous obstacles.", count));
    }

    static boolean contains(int[] arr, int i) {
        boolean res = false;
        for (int j : arr) {
            if (i == j) {
                return true;
            }
        }
        return res;
    }
}