import java.util.PriorityQueue;

/**
 * aka sorting a K-sorted array
 */
public class SortAlmostSortedArray {
    private void sortKSortedArray(int[] arr, int k) {
        if(arr.length <= 1) {
            return;
        }
        // create a min heap of size k
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        // insert first k + 1 elements
        for(int i = 0; i < k + 1; i++)
            pQ.offer(arr[i]);
        int j = 0;
        for(int i = k + 1; i < arr.length; i++) {
            arr[j++] = pQ.poll();
            pQ.offer(arr[i]);
        }
        while(!pQ.isEmpty()) {
            arr[j++] = pQ.poll();
        }
    }

    private void printArr(int[] arr) {
        for(int val:arr)
            System.out.print(val + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        SortAlmostSortedArray sorter = new SortAlmostSortedArray();
        int[] arr = {6,5,3,2,8,10,9};
        sorter.printArr(arr);
        sorter.sortKSortedArray(arr, 3);
        sorter.printArr(arr);
    }
}
