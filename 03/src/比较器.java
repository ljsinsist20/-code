import java.util.Comparator;
import java.util.PriorityQueue;

public class 比较器 {
    public static void main(String[] args) {
        PriorityQueue<Integer> head = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        head.add(9);
        head.add(23);
        head.add(3);
        head.add(1);
        head.add(213);
        head.add(3123);
        head.add(5);
        while (!head.isEmpty()) {
            System.out.println(head.poll());
        }

    }
}
