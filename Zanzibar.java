import java.util.ArrayList;

class Zanzibar {
    
    static Kattio io = new Kattio(System.in);
    
    public static void main(String[] args) {
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve();
        }
        io.close();
    }
    
    static void solve() {
        int res = 0;
        ArrayList<Integer> lst = new ArrayList<>();
        int curr = io.getInt();
        while (curr != 0) {
            lst.add(curr);
            curr = io.getInt();
        }
        for (int j = 1; j < lst.size(); j++) {
            if (lst.get(j) > lst.get(j - 1) * 2) {
                res += lst.get(j) - lst.get(j - 1) * 2;
            }
        }
        io.println(res);
    }
}