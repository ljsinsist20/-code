import java.util.PriorityQueue;

public class 小根堆 {
    public static void main(String[] args) {
        int[] arr = {2, 34, 556, 7, 8, 23, 1, 9};
        sort(arr, 6);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void sort(int[] arr, int k) {
        PriorityQueue<Integer> head = new PriorityQueue<>();
        int index = 0;
        for (; index <= Math.min(arr.length, k); index++) {
            head.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            head.add(arr[index]);
            arr[i] = head.poll();
        }
        while (!head.isEmpty()) {
            arr[i++] = head.poll();
        }
    }
}
