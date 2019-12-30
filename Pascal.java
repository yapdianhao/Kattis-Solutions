class Pascal {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        if (n == 1) {
            io.println(0);
            io.close();
            return;
        }
        int counter = 0;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                counter = i;
                break;
            }
        }
        //io.println(counter);
        if (counter == 0) io.println(n - 1);
        else io.println(n - ((int) n / counter));
        io.close();
    }
}