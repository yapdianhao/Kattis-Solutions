import java.util.Hashtable;
import java.math.BigInteger;

class CountAna {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        //String word = io.getWord();
        //char[] arr = word.toCharArray();
        //String s = io.getWord();
        while (io.hasMoreTokens()) {
            String s = io.getWord();
            solve(s);
            //hs = io.getWord();
        }
        io.close();
    }

    static BigInteger fact(int n) {
        if (n <= 1) return new BigInteger("1");
        else return new BigInteger(n + "").multiply(fact(n - 1));
    }

    static void solve(String s) {
        char[] arr = s.toCharArray();
        BigInteger num = fact(arr.length);
        Hashtable<Character, Integer> ht = new Hashtable<>();
        for (char c : arr) {
            if (!ht.keySet().contains(c)) {
                ht.put(c, 1);
            } else {
                ht.put(c, ht.get(c) + 1);
            }
        }
        for (int i : ht.values()) {
            num = num.divide(fact(i));
        }
        //io.println(ht.values());
        //io.println(ht);
        io.println(num);
        io.flush();
    }
}