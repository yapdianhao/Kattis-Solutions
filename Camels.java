import java.util.Arrays;

class Camels {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int camels = io.getInt();
        int[] jaap = new int[camels];
        int[] jan = new int[camels];
        int[] thij = new int[camels];
        jaap = readInput(jaap);
        jan = readInput(jan);
        thij = readInput(thij);
        long total = ((long) camels * (long) (camels - 1)) / 2;
        long invJaap = countInv(jaap);
        long invJan = countInv(jan);
        long invThij = countInv(thij);
        int[] jaapjan = addArrays(jaap, jan);
        int[] janthij = addArrays(jan, thij);
        int[] thijjaap = addArrays(thij, jaap);
        io.println(invJaap);
        io.println(invJan);
        io.println(invThij);

        // int[] arr = { 1, 2, 3 };
        // io.println(countInv(arr));
        // long total = (long) camels * (long) (camels - 1) / 2;
        // io.println((total - invJan - invThij - invJaap) / 2);
        io.close();
    }

    static int[] addArrays(int[] arr1, int[] arr2) {
        int[] newArr = new int[2 * arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            newArr[i] = arr1[i];
        }
        for (int i = 0; i < arr1.length; i++) {
            newArr[i + arr1.length] = arr2[i];
        }
        return newArr;
    }

    static long countInv(int[] arr) {
        if (arr.length <= 1)
            return 0;
        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        long ansLeft = countInv(left);
        long ansRight = countInv(right);
        return ansLeft + ansRight + merge(left, right, arr);
    }

    static long merge(int[] left, int[] right, int[] arr) {
        long inv = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length || j < right.length) {
            if (i >= left.length) {
                arr[k++] = right[j++];
            } else if (j >= right.length) {
                arr[k++] = left[i++];
            } else {
                if (left[i] <= right[j]) {
                    arr[k++] = left[i++];
                } else {
                    inv += (left.length - i);
                    // io.println("INV: " + inv);
                    arr[k++] = right[j++];
                }
            }
        }
        return inv;
    }

    static int[] readInput(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = io.getInt();
        }
        return arr;
    }
}