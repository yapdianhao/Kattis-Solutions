import java.util.*;

class Tarifa {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int quota = scn.nextInt();
        int size = scn.nextInt();
        int[] usages = new int[size];
        for (int i = 0; i < size; i++) {
            usages[i] = scn.nextInt();
        }
        int total = quota;
        for (int i : usages) {
            total += quota - i;
        }
        System.out.println(total);

    }
}