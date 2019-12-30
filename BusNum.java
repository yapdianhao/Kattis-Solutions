import java.util.Arrays;

class BusNum {
    
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int nums = io.getInt();
        int[] arr = new int[nums];
        for (int i = 0; i < nums; i++) {
            arr[i] = io.getInt();
        }
        Arrays.sort(arr);
        int curr = arr[0];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 == arr.length) {
                if (count > 1) {
                    io.print(curr + "-" + arr[i]);
                    io.println();
                } else if (count == 1) {
                    io.print(curr + " " + arr[i]);
                    io.println();
                } else if (count == 0) {
                    io.print(arr[i]);
                    io.println();
                }
                break;
            }
            if (arr[i + 1] == arr[i] + 1) {
                count++;
            } else if (arr[i + 1] != arr[i] + 1) {
                if (count > 1) {
                    io.print(curr + "-" + arr[i] + " ");
                } else if (count == 1) {
                    io.print(curr + " " + arr[i] + " ");
                } else if (count == 0) {
                    io.print(curr+ " ");
                }
                curr = arr[i + 1];
                count = 0;
            }
        }
        io.close();
    }
}