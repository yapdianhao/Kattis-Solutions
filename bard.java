import java.util.*;

class Bard {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int villagers = io.getInt();
        int nights = io.getInt();
        int[] arr = new int[villagers];
        while (nights-- > 0) {
            int present = io.getInt();
            int[] presentVillagers = new int[present];
            for (int i = 0; i < present; i++) {
                presentVillagers[i] = io.getInt() - 1;
            }
            Arrays.sort(presentVillagers);
            if (presentVillagers[0] == 0) {
                for (int i = 0; i < present; i++) {
                    arr[presentVillagers[i]]++;
                }
            } else {
                int max = 0;
                for (int i = 0; i < present; i++) {
                    if (arr[presentVillagers[i]] > max) {
                        max = arr[presentVillagers[i]];
                    }
                }
                for (int i = 0; i < present; i++) {
                    arr[presentVillagers[i]] = max;
                }
            }
        }
        for (int i = 0; i < villagers; i++) {
            if (arr[i] == arr[0]) {
                io.println(i + 1);
            }
        }
        io.close();
    }
}