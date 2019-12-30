import java.util.Arrays;

class Trik {
    
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        boolean[] arr = new boolean[3];
        arr[0] = true;
        char[] seq = io.getWord().toCharArray();
        for (char c : seq) {
            if (c == 'A') {
                boolean f = arr[0];
                arr[0] = arr[1];
                arr[1] = f;
            } else if (c == 'B') {
                boolean f = arr[2];
                arr[2] = arr[1];
                arr[1] = f;                
            } else {
                boolean f = arr[2];
                arr[2] = arr[0];
                arr[0] = f;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (arr[i]) {
                io.println(i + 1);
                io.close();
                return;
            }
        }
    }
}