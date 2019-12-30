import java.util.Arrays;

class Luhn {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
       int strings = io.getInt();
       for (int i = 0; i < strings; i++) {
        solve();
       }
       io.close();
    }

    static void solve() {
        char[] chars = io.getWord().toCharArray();
        int[] arr = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            arr[i] = Character.getNumericValue(chars[i]);
        }
        for (int i = 0 ; i < arr.length; i++) {
            if (i % 2 == 1) {
                if (arr[arr.length - 1 - i] * 2 >= 10) {
                    arr[arr.length - 1 - i] = single(arr[arr.length - 1 - i]  * 2);
                } else arr[arr.length - 1 - i] = arr[arr.length - 1 - i] * 2;
            }
        }
        int res = 0;
        for (int i : arr) res += i;
        //io.println(Arrays.toString(arr)); 
        if (res % 10 == 0) io.println("PASS");
        else io.println("FAIL");
    }

    static int single(int n) {
        int res = 0;
        char[] temp = (n + "").toCharArray();
        for (char c : temp) res += Character.getNumericValue(c);
        return res;
    }

}