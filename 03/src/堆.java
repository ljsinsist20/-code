public class 堆 {
    public static void main(String[] args) {
        //大根堆
        int[] arr = {6, 7, 5, 3, 6};
        find(arr, 0);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("1==============================");

        //返回最大值并移除，并保持大根堆
        int maxNum = find_plus(arr, 0, arr.length);
        System.out.println(maxNum+"==========");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("2==============================");
    }

    //heapify
    private static int find_plus(int[] arr, int index, int headSize) {
        int maxNum = arr[0];
        arr[0] = arr[--headSize];
        int left = index * 2 + 1;
        while (left < headSize) {
            //孩子比
            int largest = left + 1 < headSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //父孩比
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
        return maxNum;
    }


    //heapinsert
    private static void find(int[] arr, int index) {
        int headSize = 0;
        for (int i = 0; i < arr.length; i++) {
            index = headSize++;
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }
    }



    private static void swap(int[] arr, int x, int y) {
        int flag = 0;
        flag = arr[x];
        arr[x] = arr[y];
        arr[y] = flag;
    }
}
