import java.util.Arrays;

class Turtle {

    static Kattio io = new Kattio(System.in);
    static char d = 'E';
    static int x = -1;
    static int y = -1;
    static char[][] map = new char[8][8];

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            map[i] = io.getWord().toCharArray();
        }
        char[] directions = io.getWord().toCharArray();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == 'T') {
                    x = i;
                    y = j;
                }
            }
        }
        try {
            for (char c : directions) {
                if (c == 'F') {
                    if (!gotIce()) go();
                    if (map[x][y] == 'C') {
                        //io.println(x + ", " + y);
                        io.println("Bug!");
                        io.close();
                        return;
                    } 
                } else if (c == 'X') {
                    if (gotIce()) removeIce();
                    else {
                        io.println("Bug!");
                        io.close();
                        return;
                    }
                } else if (c == 'L') {
                    turnLeft();
                } else if (c == 'R') {
                    turnRight();
                }
            }
            //io.println(x + " " + y);
            io.println(map[x][y] == 'D' ? "Diamond!" : "Bug!");
            io.close();
        } catch(Exception e) {
            io.println("Bug!");
            io.close();
            return;
        }
    }

    static void turnLeft() {
        if (d == 'E') d = 'N';
        else if (d == 'S') d = 'E';
        else if (d == 'N') d = 'W';
        else if (d == 'W') d = 'S';
    }

    static void turnRight() {
        if (d == 'E') d = 'S';
        else if (d == 'S') d = 'W';
        else if (d == 'N') d = 'E';
        else if (d == 'W') d = 'N';
    }

    static void removeIce() {
        if (d == 'E') map[x][y + 1] = '.';
        else if (d == 'S') map[x + 1][y] = '.';
        else if (d == 'N') map[x - 1][y] = '.';
        else if (d == 'W') map[x][y - 1] = '.';
    }

    static boolean gotIce() {
        if (d == 'E') return map[x][y + 1] == 'I';
        else if (d == 'S') return map[x + 1][y] == 'I';
        else if (d == 'N') return map[x - 1][y] == 'I';
        else return map[x][y - 1] == 'I';
    }

    static void go() {
        if (d == 'E') y++;
        else if (d == 'S') x++;
        else if (d == 'N') x--;
        else if (d == 'W') y--;
    }
}