import java.util.Arrays;
import java.util.ArrayList;

class Camels2 {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int camels = io.getInt();
        int[] jaap = new int[camels];
        int[] jan = new int[camels];
        int[] thij = new int[camels];
        jaap = readInput(jaap);
        jan = readInput(jan);
        thij = readInput(thij);
        long invJaap = countInv(jaap, jan);
        io.println(invJaap);
        io.close();
    }

    static long countInv(int[] arr1, int[] arr2) {
        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));
        long ct = 0;
        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));
        ArrayList<Integer> lst1 = new ArrayList<>();
        ArrayList<Integer> lst2 = new ArrayList<>();
        for (int i : arr1)
            lst1.add(i);
        for (int i : arr2)
            lst2.add(i);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(lst1);
            System.out.println(lst2);
            int idx = binarySearch(lst1, arr2[i]);
            ct += idx;
            lst1.remove(idx);
            lst2.remove(Integer.valueOf(arr2[i]));
        }
        return ct;
    }

    static int binarySearch(ArrayList<Integer> ll, int target) {
        int low = 0;
        int high = ll.size() - 1;
        while (low <= high) {
            // System.out.println(low + " " + high);
            int mid = (low + high) / 2;
            if (ll.get(mid) == target)
                return mid;
            else if (ll.get(mid) < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    static int[] readInput(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = io.getInt();
        }
        return arr;
    }
}
