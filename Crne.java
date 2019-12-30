class Crne {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        long n = io.getLong();
        long f = n / 2;
        long temp = f;
        if (f + temp < n) {
            f++;
        }
        io.println((f + 1) * (temp + 1));
        io.close();
    }
}