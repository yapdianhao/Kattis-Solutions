class AlmostPerfect {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        while (io.hasMoreTokens()) {
            long input = io.getInt();
            long sum = 0;
            for (int i = 1; i <= Math.sqrt(input); i++) {
                if (input % i == 0) {
                    sum += i;
                    if (input / i != i) {
                        sum += input / i;
                    }
                }
            }
            // "HOW FAR WILL DISCRETE MATH TAKE YOU?"
            // This is not competitive programming.
            // This is math, understanding that the greater divisor 
            // of an integer n will not fall below sqrt(n).
            sum -= input;
            if (sum == input) {
                io.println(input + " perfect");
            } else if (Math.abs(input - sum) <= 2) {
                io.println(input + " almost perfect");
            } else {
                io.println(input + " not perfect");
            }
            io.flush();
        }
    }
}