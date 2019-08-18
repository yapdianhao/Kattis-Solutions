import java.util.*;

class Candle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int diff = sc.nextInt();
        int rita = sc.nextInt();
        int brother = sc.nextInt();
        int count = 0;
        for (int i = 0; i < rita; i++) {
            // A helper function is needed to count the candles.
            // Since Rita starts counting candles at 4, brother at 3,
            // this part ensures the fn only starts counting brother's when he is 3.
            if (i < diff - 1) {
                continue;
            // starts the helper function to count brother's sugars
            } else {
                if ((rita - helper(4, i)) == (helper(3, count) - brother)) {
                    System.out.println(helper(3, count) - brother);
                    break;
                } else {
                    count++;
                }
            }
        }
    }

    // a helper function to increment the candles
    static int helper(int age, int diff) {
        int count = age;
        for (int i = 0; i < diff; i++) {
            count ++;
            age += count;
        }
        return age;
    }
}
