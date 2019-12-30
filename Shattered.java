class Shattered {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int width = io.getInt();
        int cakes = io.getInt();
        int count = 0;
        while (cakes-- > 0) {
            count += io.getInt() * io.getInt();
        }
        io.println((int) count / width);
        io.close();
    }
}