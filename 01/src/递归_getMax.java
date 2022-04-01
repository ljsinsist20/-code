public class 递归_getMax {
    public static void main(String[] args) {
//        int[] arr = {23, 34, 342, 1, 23, 8888, 45, 56, 34, 5, 99};
        int[] arr = {1,3,4,5};
        int numMax = getMax(arr, 0, arr.length - 1);
        System.out.println(numMax);
    }

    private static int getMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = getMax(arr, L, mid);
        int rightMax = getMax(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
