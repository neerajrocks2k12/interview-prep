import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueExample {

    private static Integer getNextRandom(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(7);
        for(int i = 0; i < 7; i++) {
            int nextVal = getNextRandom(i + 100);
            System.out.print(nextVal + " ");
            pQ.offer(nextVal);
        }

        System.out.println("\nPrinting priorityQ");
        Iterator<Integer> iterator = pQ.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\nPolling priorityQ");
        while(!pQ.isEmpty()) {
            System.out.print(pQ.poll() + " ");
        }
    }
}
