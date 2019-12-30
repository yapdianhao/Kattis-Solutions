class ReverseBin {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        String temp = "" + Integer.toBinaryString(n);
        String to = "";
        for (int i = temp.length() - 1; i > -1; i--) {
            to += temp.substring(i, i + 1);
        }
        io.println(Integer.parseInt(to, 2));
        io.close();
    }
}