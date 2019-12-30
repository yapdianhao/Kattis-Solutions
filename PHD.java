import java.util.*;

class PHD{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        String[] arr = new String[nums];
        for (int i = 0; i < nums; i++) {
            arr[i] = sc.next();
        }
        for (int i = 0; i < nums; i++) {
            String s = arr[i];
            if (s.equals("P=NP")) {
                System.out.println("skipped");
            } else {
                int index = s.indexOf('+');
                int first = Integer.parseInt(s.substring(0, index));
                int sec = Integer.parseInt(s.substring(index + 1, s.length()));
                System.out.println(first + sec);
            }
        }
    }
}