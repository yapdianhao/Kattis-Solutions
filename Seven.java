class Seven {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        char[] arr = io.getWord().toCharArray();
        int[] lst = new int[3];
        for (char c : arr) {
            if (c == 'T') lst[2]++;
            else if (c == 'G') lst[1]++;
            else if (c == 'C') lst[0]++;
        }
        int min = lst[0];
        for (int i : lst) {
            if (i < min) min = i;
        }
        int res = 0;
        for (int i : lst) {
            res += i * i;
        }
        res += min * 7;
        io.println(res);
        io.close();
    }
}