import java.util.Arrays;

class TZFE {

    static Kattio io = new Kattio(System.in);
    static int[][] matrix = new int[4][4];

    public static void main(String[] args) {
        // /Kattio io = new Kattio(System.in);
        //int[][] matrix = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = io.getInt();
            }
        }
        int cmd = io.getInt();
        if (cmd == 0) pushLeft();
        else if (cmd == 1) pushUp();
        else if (cmd == 2) pushRight();
        else if (cmd == 3) pushDown();
        //transpose();
        //pushUp();
        //pushRight();
        //mirrorUp();
        //pushDown();
        for (int i = 0; i < 4; i++) {
            //pushLeft();
            for (int j = 0; j < 4; j++) {
                io.print(matrix[i][j] + " ");
            }
            io.println();
        }
        io.close();
    }

    /*
        2 4 4 4
        2 2 4 4
        2 4 2 2
        2 4 2 4
    */

    static void transpose() {
        boolean[][] swapped = new boolean[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!swapped[i][j] && !swapped[j][i]) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                    swapped[i][j] = swapped[j][i] = true;
                }
            }
        }
    }

    static void pushLeft() {
        for (int x = 0; x < 4; x++) {
            int[] r = matrix[x];
            int curr = 0;
            int j = 1;
            while (j < 4) {
                //io.println(true);
                if (r[j] == 0) {
                    j++;
                    continue;
                }
                else if (r[j] != r[curr]) {
                    curr = j;
                    j++;
                } else if (r[j] == r[curr]) {
                    r[curr] += r[j];
                    //System.out.println(r[curr]);
                    r[j] = 0;
                    curr = j;
                    j++;
                }
            }
            curr = 0;
            int[] copy = new int[4];
            for (int i = 0; i < 4; i++) {
                if (r[i] != 0) {
                    copy[curr++] = r[i];
                }
            }
            for (int i = 0; i < 4; i++) {
                r[i] = copy[i];
            }
            //io.println(Arrays.toString(r));
        }
    }

    static void mirror() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][3 - j];
                matrix[i][3 - j] = temp;
            }
        }
    }

    static void mirrorUp() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[3 - i][j];
                matrix[3 - i][j] = temp;
            }
        }
    }
    static void pushUp() {
        transpose();
        pushLeft();
        transpose();
    }

    static void pushRight() {
        mirror();
        pushLeft();
        mirror();
    }


    static void pushDown() {
        mirrorUp();
        pushUp();
        mirrorUp();
    }
}