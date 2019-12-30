import java.util.Scanner;

class ColdPuterScience {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int temps = sc.nextInt();
        for (int i = 0; i < temps; i++) {
            int next = sc.nextInt();
            if (next < 0) {count ++;}
        }
        System.out.println(count);
    }
}