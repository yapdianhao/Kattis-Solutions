import java.util.*;

class Kattis {

    public static void main(String[] args) {
        Kattio kattio = new Kattio(System.in, System.out);
        int commands = kattio.getInt();
        PriorityQueue<Quest> q1 = new PriorityQueue<Quest>(commands, new QuestComparator());
        PriorityQueue<Quest> q2 = new PriorityQueue<Quest>(commands, new QuestComparator());
        for (int i = 0; i < commands; i++) {
            String action = kattio.getWord();
            if (action.equals("add")) {
                Quest quest = new Quest(kattio.getInt(), kattio.getInt());
                q1.add(quest);
            } else {
                kattio.println(true);
                int gold = 0;
                int energy = kattio.getInt();
                while (!q1.isEmpty()) {
                    Quest popped = q1.poll();
                    if (popped.energy < energy) {
                        energy -= popped.energy;
                        gold += popped.gold;
                    } else {
                        q2.add(popped);
                        if (energy <= 0) {
                            break;
                        }
                    }
                }
                while (!q2.isEmpty()) {
                    q1.add(q2.poll());
                }
                kattio.println(gold);
            }
        }
        kattio.close();
    }
}