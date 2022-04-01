public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {2, 34, 556, 7, 8, 23, 1, 9};
        int[] arrNew = sort(arr);
        for (int i : arrNew) {
            System.out.println(i);
        }
    }

    private static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int j, int h) {
        arr[j] = arr[j] ^ arr[h];
        arr[h] = arr[j] ^ arr[h];
        arr[j] = arr[j] ^ arr[h];
    }
}

class test插入排序 {
    public static void main(String[] args) {
        int[] arr = {2, 34, 556, 7, 8, 23, 1, 9};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
