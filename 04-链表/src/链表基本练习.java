/**
 * @author ：ljs
 * @date ：Created in 2022/3/13 11:36
 */
public class 链表基本练习 {
    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
//        System.out.println("====================================");

        Node newHead = reversal(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    private static Node reversal(Node head) {
        Node n1 = head;
        Node n2 = head.next;
        Node n3 = n2.next;
        while (n3 != null) {
            n2.next = n1;
            n1 = n2;
            n2 = n3;
            n3 = n2.next;
        }
        return n2;
    }
}
