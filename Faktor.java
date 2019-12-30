import java.util.*;

class Faktor{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int factor = sc.nextInt();
        System.out.println(first * (factor - 1) + 1);   
    }
}