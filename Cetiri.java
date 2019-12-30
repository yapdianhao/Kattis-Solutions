import java.util.*;

class Cetiri {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        if (arr[2] - arr[1] == arr[1] - arr[0]) {
            System.out.println(arr[2] + arr[2] - arr[1]);
        } else {
            int diff = Math.min(arr[2] - arr[1], arr[1] - arr[0]);
            if (arr[2] - arr[1] < arr[1] - arr[0]) {
                System.out.println(arr[0] + diff);
            } else {
                System.out.println(arr[1] + diff);
            }
        }
    }
}