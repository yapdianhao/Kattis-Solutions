import java.util.*;
import java.io.*;

class Relay {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int runners = Integer.parseInt(br.readLine());
        String[] names = new String[runners];
        double[] firstLap = new double[runners];
        double[] laps = new double[runners];
        PriorityQueue<Runner> pq = new PriorityQueue<Runner>(runners, new RunnerComparator());
        for (int i = 0; i < runners; i++) {
            String[] inputs = br.readLine().split(" ");
            Runner runner = new Runner(inputs[0], Double.parseDouble(inputs[1]), Double.parseDouble(inputs[2]));
            pq.add(runner);
        }
        ArrayList<Runner> runner = new ArrayList<Runner>();
        for (int i = 0; i < 2; i++) {
            runner.add(pq.poll());
        }
        Runner r3 = pq.poll();
        Runner r4 = pq.poll();
        if (r4.otherLap - r3.otherLap < r4.firstLap - r3.firstLap) {
            runner.add(r4);
            runner.add(r3);
        } else {
            runner.add(r3);
            runner.add(r4);
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(runner.get(i).name);
        }
    }
}