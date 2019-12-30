class Tutorial {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        double c = io.getInt();
        double n = io.getDouble();
        int t = io.getInt();
        if (t == 1) {
            n = one(n, c);
        } else if (t == 2) {
            n = two(n);
        } else if (t == 3) {
            n = three(n);
        } else if (t == 4) {
            n = four(n);
        } else if (t == 5) {
            n = five(n);
        } else if (t == 6) {
            n = six(n);
        } else {
            n = seven(n);
        }
        io.println(n <= c ? "AC" : "TLE");
        //io.println(r);
        io.close();
    }

    static double one(double n, double c) {
        double temp = 1;
        while (n > 0) {
            temp *= n;
            n--;
            if (temp > c) return c + 1;
        }
        return temp;
    }

    static double two(double n) {
        return (double)Math.pow(2, n);
    }

    static double three(double n) {
        return (double)Math.pow(n, 4);
    }

    static double four(double n) {
        return (double)Math.pow(n, 3);
    }

    static double five(double n) {
        return (double)Math.pow(n, 2);
    }

    static double six(double n) {
        return (double)n * (double)(Math.log(n) / Math.log(2));
    }

    static double seven(double n) {
        return n;
    }
}