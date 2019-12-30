class Square {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        if (n % 2 != 0) {
            for (int i = 0; i < n / 2 + 1; i++) {
                if (i % 2 == 0) {
                    io.println(generateStuffs(i, n));
                } else {
                    io.println(generateBlanks(i, n));
                }
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                if (i % 2 == 0) {
                    io.println(generateStuffs(i, n));
                } else {
                    io.println(generateBlanks(i, n));
                }
            }            
        }
        if (n % 2 != 0) {
            for (int i = n / 2 + 1; i < n; i++) {
                if (i % 2 == 0) {
                    //io.println(i);
                    io.println(generateStuffs(n - (i + 1), n));
                } else {
                    //io.println(i);
                    io.println(generateBlanks(n - (i + 1), n));
                }
            }
        } else {
            for (int i = n / 2; i < n; i++) {
                if (i % 2 == 0) {
                    //io.println(i);
                    io.println(generateBlanks(n - (i + 1), n));
                } else {
                    //io.println(i);
                    io.println(generateStuffs(n - (i + 1), n));
                }
            }            
        }
        //io.println("=======");
        //io.println(generateStuffs(2, 3));
        io.close();

    }

    static String generateStuffs(int x, int n) {
        String s = "";
        String mid = "";
        for (int i = 0; i < n - 2 * x; i++) {
            mid += "#";
        }
        for (int i = 0; i < x / 2; i++) {
            s += "# ";
        }
        s += mid;
        for (int i = 0; i < x / 2; i++) {
            s += " #";
        }
        return s;
    }

    //this is the hardest one!!
    static String generateBlanks(int x, int n) {
        String s = "#";
        String mid = "";
        for (int i = 0; i < n - 2 * x; i++) {
            mid += " ";
        }
        for (int i = 0; i < x / 2; i++) {
            s += " #";
        }
        s += mid;
        for (int i = 0; i < x / 2; i++) {
            s += "# ";
        }
        return s + "#";
    }
}