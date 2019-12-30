import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Babelfish {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        Map<String, String> hashmap = new HashMap<String, String>();
        while (inputs.length > 1) {
            hashmap.put(inputs[1], inputs[0]);
            inputs = br.readLine().split(" ");
        }
        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }
            System.out.println(hashmap.get(input) != null ? hashmap.get(input) : "eh");
        }
    }
}
