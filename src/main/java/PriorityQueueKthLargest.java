import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueKthLargest {
    public static void main(String[] args) {
        Random random = new Random();
        PriorityQueue<Integer> pQ = new PriorityQueue<>(3);
        int[] a = {100, 30, 0, 1, 20, 70};
        int[] b = {100, 30, 0, 1, 20, 70};
        Arrays.sort(b);
        Arrays.stream(b).forEach(e -> System.out.print(e + " "));
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.println(pQ);
            if (pQ.size() >= 3)
                System.out.println("polled: " + pQ.poll());
            pQ.offer(-a[i]);
        }
        System.out.println(pQ);
    }

    private static void printQ(PriorityQueue<Integer> pQ) {

    }
}
