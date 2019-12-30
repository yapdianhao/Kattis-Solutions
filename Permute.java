import java.util.Arrays;

class Permute {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int[] lst = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    lst[j] = arr[i];
                }
                System.out.println(Arrays.toString(lst));
            }
        }
    }
}