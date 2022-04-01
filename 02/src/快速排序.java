public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = {2, 34, 556, 7, 8, 23, 1, 9};
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    //快排3.0
    private static void sort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            sort(arr, L, p[0] - 1);
            sort(arr, p[1] + 1, R);
        }
    }

    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, L++, ++less);
            } else if (arr[L] > arr[R]) {
                swap(arr, L, --more);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{++less, more};
    }

    private static void swap(int[] arr, int x, int y) {
        int flag = 0;
        flag = arr[x];
        arr[x] = arr[y];
        arr[y] = flag;
    }
}
