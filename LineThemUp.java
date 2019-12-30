import java.util.Arrays;
import java.util.Collections;

class LineThemUp {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        String[] inc = new String[n];
        String[] dec = new String[n];
        String[] temp = new String[n];
        for (int i = 0; i < n; i++) {
            String s = io.getWord();
            inc[i] = dec[i] = temp[i] = s;
        }
        Arrays.sort(inc);
        Arrays.sort(dec, Collections.reverseOrder());
        if (Arrays.equals(inc, temp)) {
            io.println("INCREASING"); 
        } else if (Arrays.equals(dec, temp)) {
            io.println("DECREASING");
        } else {
            io.println("NEITHER");
        }
        io.close();
    }
}