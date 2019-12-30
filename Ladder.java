class Ladder {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int w = io.getInt();
        int a = io.getInt();
        io.println((int)Math.ceil(w / Math.sin(Math.toRadians(a))));
        io.close();
    }
}