public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = {2, 34, 556, 7, 8, 23, 1, 9};
        //一个数一个数的进行
//        for (int i = 0; i < arr.length; i++) {
//            headInsert(arr, i);
//        }
        //整体进行
        for (int i = arr.length - 1; i >= 0; i--) {
            headify(arr, i, arr.length);
        }
        int headSize = arr.length;
        swap(arr, 0, --headSize);
        while (headSize > 0) {
            headify(arr, 0, headSize);
            swap(arr, 0, --headSize);
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void headInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void headify(int[] arr, int index, int headSize) {
        int left = index * 2 + 1;
        while (left < headSize) {
            int largest = left + 1 < headSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int flag = 0;
        flag = arr[x];
        arr[x] = arr[y];
        arr[y] = flag;
    }
}
