class FizzBuzz {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int f = io.getInt();
        int b = io.getInt();
        int m = io.getInt();
        for (int i = 1; i < m + 1; i++) {
            if (i % f == 0 && i % b == 0) {
                io.println("FizzBuzz");
            } else if (i % f == 0) {
                io.println("Fizz");
            } else if (i % b == 0) {
                io.println("Buzz");
            } else {
                io.println(i);
            }
        }
        io.close();
    }
}