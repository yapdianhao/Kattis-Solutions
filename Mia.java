import java.util.*;

class Mia {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int token = sc.nextInt();
        while (token != 0) {
            int[] first = new int[2];
            int[] sec = new int[2];
            first[0] = token;
            first[1] = sc.nextInt();
            sec[0] = sc.nextInt();
            sec[1] = sc.nextInt();
            System.out.println(determine(first, sec));
            token = sc.nextInt();
        }

    }

    static String determine(int[] first, int[] sec ){
        if (((first[0] == 1 && first[1] == 2) || (first[0] == 2 && first[1] == 1)) && ((sec[0] == 1 && sec[1] == 2) || 
            (sec[0] == 2 && sec[1] == 1))){
            return "Tie.";
        } else if ((first[0] == 1 && first[1] == 2) || (first[0] == 2 && first[1] == 1)) {
            return "Player 1 wins.";
        } else if ((sec[0] == 1 && sec[1] == 2) || (sec[0] == 2 && sec[1] == 1)) {
            return "Player 2 wins.";
        } else if ((first[0] == first[1]) && (sec[0] != sec[1])) {
            return "Player 1 wins.";
        } else if ((sec[0] == sec[1]) && (first[0] != first[1])) {
            return "Player 2 wins.";
        } else if ((first[0] == first[1]) && (sec[0] == sec[1]) && (first[0] > sec[0])) {
            return "Player 1 wins.";
        } else if ((first[0] == first[1]) && (sec[0] == sec[1]) && (first[0] < sec[0])) {
            return "Player 2 wins.";
        } else if ((first[0] == first[1]) && (sec[0] == sec[1]) && (first[0] == sec[0])) {
            return "Tie.";
        } else {
            return case3(first, sec);
        }
    }

    static String case3(int[] first, int[] sec) {
        int new1 = Integer.parseInt("" + Math.max(first[0], first[1]) + Math.min(first[0], first[1]));
        int new2 = Integer.parseInt("" + Math.max(sec[0], sec[1]) + Math.min(sec[0], sec[1]));
        if (new1 > new2) {
            return "Player 1 wins.";
        } else if (new1 == new2) {
            return "Tie.";
        } else {
            return "Player 2 wins.";
        }
    }
}