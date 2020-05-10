import java.util.*;

class Toilet {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        char[] arr = io.getWord().toCharArray();
        io.println(countP1(arr));
        io.println(countP2(arr));
        io.println(countP3(arr));
        io.close();
    }

    // always up
    static int countP1(char[] arr) {
        int p1 = 0;
        char curr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // toilet seat down, people want up, policy up
            if (curr != arr[i] && curr == 'D') {
                curr = 'U';
                p1++;
            } else if (curr == arr[i] && curr == 'D') {// toilet seat down, people want down, policy up
                curr = 'U';
                p1++;
            } else if (curr != arr[i] && curr == 'U') {// toilet seat up, people want down
                p1 += 2;
            }
        }
        return p1;
    }

    static int countP2(char[] arr) {
        int p2 = 0;
        char curr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (curr != arr[i] && curr == 'D') { // toilet down, people want up, policy down
                p2 += 2;
            } else if (curr != arr[i] && curr == 'U') {// toilet up, people want up
                p2++;
                curr = 'D';
            } else if (curr == arr[i] && curr == 'U') {// toilet up, people want up
                p2++;
                curr = 'D';
            }
        }
        return p2;
    }

    static int countP3(char[] arr) {
        int p3 = 0;
        char curr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // people want up, toilet down
            if (arr[i] == 'U' && curr != arr[i]) {
                curr = arr[i];
                p3++;
            } else if (arr[i] == 'D' && curr != arr[i]) {// people want down, toilet up
                curr = arr[i];
                p3++;
            }
        }
        return p3;
    }
}