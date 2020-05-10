import java.util.*;

class Palindrome {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        while (io.hasMoreTokens()) {
            String input = io.getWord();
            solve(input);
            io.println();
            //io.flush();
        }
        io.close();
    }

    static void solve(String word) {
        TreeSet<String> palindromes = new TreeSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (int j = 2; j <= word.length() - i; j++) {
                String curr = word.substring(i, i + j);
                //if (curr.length() == 1) continue;
                if (isPalindrome(curr)) {
                    palindromes.add(curr);
                }
            }
        }
        for (String s : palindromes) {
            io.println(s);
        }
    }

    static boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}