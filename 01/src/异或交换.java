public class 异或交换 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int i = 1;
        int j = 2;
        int[] newArr = exap(arr, i, j);
        System.out.println(2^2);
        for (int x : newArr) {
//            System.out.println(x);
        }
    }

    private static int[] exap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        return arr;
    }
}
