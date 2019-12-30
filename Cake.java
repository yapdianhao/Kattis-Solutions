class Cake {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int cake = io.getInt();
        int cut1 = io.getInt();
        int cut2 = io.getInt();
        int length = Math.max(cake - cut1, cut1);
        int width = Math.max(cake - cut2, cut2);
        io.println(length * width * 4);
        io.close();
    }
}