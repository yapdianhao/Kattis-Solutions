import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

class ContinuosMedian {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int cases = io.getInt();
        for (int i = 0; i < cases; i++) {
            solve(); 
        }
        io.close();
    }

    static void solve() {
        int size = io.getInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = io.getInt();
        }
        //Arrays.sort(arr);
        io.println(genMedian(arr));
    }

    static long genMedian(int[] arr) {
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] temp = Arrays.copyOf(arr, i + 1);
            Arrays.sort(temp);
            if (i % 2 != 0) {
                res += (temp[i / 2] + temp[i / 2 + 1]) / 2;
            } else {
                res += temp[i / 2];
            }
            //Arrays.sort(temp);
            //io.println(Arrays.toString(temp));
            /*if (i == 0) {
                res += arr[0];
                continue;
            } else if (i % 2 == 1) {
                PriorityQueue<Integer> minHeap = new PriorityQueue<>(i / 2 + 1);
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(i / 2 + 1, Collections.reverseOrder());
                for (int j = 0; j <= i; j++) {
                    if (minHeap.isEmpty()) minHeap.add(arr[j]);
                    else if (minHeap.size() - maxHeap.size() >= 1 && arr[j] > minHeap.peek()) {
                        if (arr[j] == 7) System.out.println(minHeap.peek() + "fuck");
                        maxHeap.add(minHeap.poll());
                        minHeap.add(arr[j]);
                    } else if (minHeap.size() - maxHeap.size() >= 1 && arr[j] < minHeap.peek()) {
                        if (arr[j] == 7) System.out.println(minHeap.peek() + "fuck");
                        maxHeap.add(minHeap.poll());
                        minHeap.add(arr[j]);
                    } else {
                        if (minHeap.peek() < maxHeap.peek()) {
                            int temp = minHeap.poll();
                            minHeap.add(maxHeap.poll());
                            minHeap.add(arr[j]);
                            maxHeap.add(temp);
                        } else minHeap.add(arr[j]);
                    }
                }
                io.println("=======" + i + "=======");
                io.println("min: " + minHeap);
                io.println("max: " + maxHeap);
                res += (minHeap.peek() + maxHeap.peek()) / 2;
                //io.println("res: " + res);
            } else if (i % 2 == 0) {
                PriorityQueue<Integer> minHeap = new PriorityQueue<>(i / 2 + 1);
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(i / 2 + 1, Collections.reverseOrder());
                for (int j = 0; j <= i; j++) {
                    if (minHeap.isEmpty()) minHeap.add(arr[j]);
                    else if (minHeap.size() - maxHeap.size() >= 1 && arr[j] > minHeap.peek()) {
                        if (arr[j] == 7) System.out.println(minHeap.peek() + "fuck");
                        maxHeap.add(minHeap.poll());
                        minHeap.add(arr[j]);
                    } else if (minHeap.size() - maxHeap.size() >= 1 && arr[j] < minHeap.peek()) {
                        if (arr[j] == 7) System.out.println(minHeap.peek() + "fuck");
                        maxHeap.add(minHeap.poll());
                        minHeap.add(arr[j]);
                    } else {
                        if (minHeap.peek() < maxHeap.peek()) {
                            int temp = minHeap.poll();
                            minHeap.add(maxHeap.poll());
                            minHeap.add(arr[j]);
                            maxHeap.add(temp);
                        } else minHeap.add(arr[j]);
                    }
                } 
                io.println("=======" + i + "=======");
                io.println("min: " + minHeap);
                io.println("max: " + maxHeap);
                res += minHeap.peek();    
                //io.println("res: " + res);     */     
            //io.println(res);
        }
        return res;
    }
}