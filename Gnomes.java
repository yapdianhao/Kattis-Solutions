import java.util.*;

class Gnomes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gnomes = sc.nextInt();
        int remaining = sc.nextInt();
        boolean[] searched = new boolean[remaining];
        Arrays.fill(searched, false);
        int[] arr = new int[gnomes];
        for (int i = 0; i < gnomes; i++) {
            searched[arr[i] = sc.nextInt()] = true;
        }
        int i = 1;
        for(int j = 0; j < gnomes; j++) {
            for (; i < arr[j]; i++) {
                if (!searched[i]) {
                    System.out.println(i);
                }
            }
            System.out.println(arr[j]);
        }
        for (; i <= remaining; i++) {
            if (!searched[i]) {
                System.out.println(i);
            }
        }
    }
}