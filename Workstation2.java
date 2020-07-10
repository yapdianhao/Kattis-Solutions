import java.util.*;

class Workstation2 {

    static Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        int n = io.getInt();
        long m = io.getLong();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int unlocks = 0;
        Schedule[] schedules = new Schedule[n];
        for (int i = 0; i < n; i++) {
            Schedule curr = new Schedule(io.getLong(), io.getLong());
            schedules[i] = curr;
        }
        Arrays.sort(schedules);
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty()) {
                if (schedules[i].arrive - pq.peek() >= m) {
                    pq.poll();
                } else {
                    // station locked: schedules[i].arrive - pq.peek() >= m
                    // research not done: schedules[i] < pq.peek()
                    break;
                }
            }
            if (pq.isEmpty()) {
                //unlocks++;
                //pq.add(schedules[i].arrive + schedules[i].leave);
            } else if (schedules[i].arrive > pq.peek() && schedules[i].arrive - pq.peek() < m) {
                pq.poll();
                unlocks++;
            }
            pq.add(schedules[i].arrive + schedules[i].leave);
            //unlocks = Math.max(unlocks, pq.size());
        }
        io.println(unlocks);
        io.close();
    }

    static class Schedule implements Comparable<Schedule> {

        long arrive;
        long leave;

        public Schedule(long a, long s) {
            this.arrive = a;
            this.leave = s;
        }

        @Override
        public int compareTo(Schedule ot) {
            return this.arrive > ot.arrive ? 1 : -1;
        }
    }
}