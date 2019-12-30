import java.math.BigDecimal;

class DivideBy {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        BigDecimal bg = new BigDecimal(io.getWord());
        BigDecimal divisor = new BigDecimal(io.getWord());
        io.println(bg.divide(divisor));
        io.close();
    }
}