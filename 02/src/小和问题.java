import java.util.HashMap;
import java.util.Map;

public class 小和问题 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 4, 3};
        // 普通方法
        int x = find(arr);
        System.out.println("x=" + x);

        //利用map
        int y = find_plus(arr);
        System.out.println("y=" + y);

        // 利用归并递归的进阶方法(执行完得到结果并且数组变有序)
        int z = process(arr, 0, arr.length - 1);
        System.out.println("z=" + z);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return
        process(arr, L, mid) +
        process(arr, mid + 1, R) +
        mearge(arr, L, mid, R);
    }

    private static int mearge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r-p2+1) * arr[p1]  : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
        return res;
    }

    private static int find_plus(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    Integer num = map.get(arr[i]) == null ? 0 : map.get(arr[i]);
                    map.put(arr[i], ++num);
                }
            }
        }
        int all = 0;
        for (Integer key : map.keySet()) {
            Integer flag = map.get(key);
            all += key * flag;
        }
        return all;
    }

    private static int find(int[] arr) {
        int all = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    all += arr[j];
                }
            }
        }
        return all;
    }
}
