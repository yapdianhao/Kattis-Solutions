import java.util.Arrays;

class PlantTree {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int size = io.getInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = io.getInt();
        }
        Arrays.sort(arr);
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[size - 1 - i] = arr[i];
        }
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (temp[i] + i + 1 > max) max = temp[i] + i + 1;
        }
        io.println(max + 1);
        io.close();
    }
}