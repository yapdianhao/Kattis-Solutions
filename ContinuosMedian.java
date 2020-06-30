import java.util.PriorityQueue;
import java.util.Collections;

class ContMed {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        while (cases-- > 0) {
            solve();
        }
        io.close();
    }

    static void solve() {
        int nums = io.getInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums, Collections.reverseOrder());
        long total = 0;
        while(nums-- > 0) {
            int n = io.getInt();
            if (!minHeap.isEmpty() && n > minHeap.peek()) minHeap.add(n);
            else maxHeap.add(n);
            if (maxHeap.size() < minHeap.size()) maxHeap.add(minHeap.poll());
            else if (maxHeap.size() - minHeap.size() > 1) minHeap.add(maxHeap.poll());
            if (maxHeap.size() == minHeap.size()) total += (minHeap.peek() + maxHeap.peek()) / 2;
            else {
                if (maxHeap.size() > minHeap.size()) total += maxHeap.peek();
                else total += minHeap.peek();
            }
            /*
            minHeap.add(n);
            //if (minHeap.size() - maxHeap.size() > 1) maxHeap.add(minHeap.poll());
            if (!maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                int temp = minHeap.poll();
                minHeap.add(maxHeap.poll());
                maxHeap.add(temp);
            }
            if (minHeap.size() - maxHeap.size() > 1) {
                //System.out.println("here");
                maxHeap.add(minHeap.poll());
            }
            if (minHeap.size() == maxHeap.size()) {
                total += (minHeap.peek() + maxHeap.peek()) / 2;
            } else {
                total += minHeap.peek();
            }
            //io.println("MIN: " + minHeap);
            //io.println("MAX: " + maxHeap);
            //System.out.println(total);*/
        }
        io.println(total);
    }
}