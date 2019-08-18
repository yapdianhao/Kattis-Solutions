import java.util.*;

class TimeLoop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String magicWord = "Abracadabra";
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            System.out.println("" + (i + 1) + " " + magicWord);
        }
    }
}