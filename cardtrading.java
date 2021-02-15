import java.util.*;

class CardTrading {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int numDeck = io.getInt();
        int numCards = io.getInt();
        int combos = io.getInt();
        int[] arr = new int[numCards];
        for (int i = 0; i < numDeck; i++) {
            int cardNum = io.getInt() - 1;
            arr[cardNum]++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < numCards; i++) {
            int buyPrice = io.getInt();
            int sellPrice = io.getInt();
            pq.offer(new Pair(Math.max(2 - arr[i], 0) * buyPrice, arr[i] * sellPrice));
        }
        long profit = 0;
        for (int i = 0; i < combos; i++) {
            Pair curr = pq.poll();
            profit -= curr.buy;
        }
        while (!pq.isEmpty()) {
            profit += pq.poll().sell;
        }
        io.println(profit);
        io.close();
    }

}

class Pair implements Comparable<Pair>{
    int buy;
    int sell;

    public Pair(int buy, int sell) {
        this.buy = buy;
        this.sell = sell;
    }

    public int compareTo(Pair another) {
        return this.buy + this.sell - another.buy - another.sell;
    }
}