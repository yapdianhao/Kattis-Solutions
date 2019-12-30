class Pet {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int max = 0;
        int num = -1;
        for (int i = 0; i < 5; i++) {
            int temp = 0;
            for (int j = 0; j < 4; j++) {
                temp += io.getInt();
            }
            if (temp > max) {
                max = temp;
                num = i + 1;
            }
        }
        io.println(num + " " + max);
        io.close();
    }
}