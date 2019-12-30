import java.util.Arrays;
import java.util.Comparator;

class Sideway {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int r = io.getInt();
        int c = io.getInt();
        while (r != 0 || c != 0) {
            solve(r, c);
            r = io.getInt();
            c = io.getInt();
        }
        io.close();
    }

    static void solve(int row, int col) {
        char[][] matrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            String word = io.getWord();
            char[] charArr = word.toCharArray();
            for (int j = 0; j < col; j++) {
                matrix[i][j] = charArr[j];
            }
        }
        char[][] transpose = new char[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        /*for (int i = 0; i < col; i++) {
            io.println(Arrays.toString(transpose[i]));
        }*/
        Arrays.sort(transpose, new ArrayComparator());
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = transpose[j][i];
            }
            io.println(new String(matrix[i]));
        }
        io.println();
        /*for (int i = 0; i < row; i++) {
            io.println(Arrays.toString(matrix[i]));
        }*/
    }

    static class ArrayComparator implements Comparator<char[]> {

        @Override
        public int compare(char[] f, char[] s) {
            String a = new String(f).toLowerCase();
            String b = new String(s).toLowerCase();
            return a.compareTo(b);
        }
    }
}