/**
 * @author ：ljs
 * @date ：Created in 2022/3/11 21:45
 * @description：基数排序详解
 * @version: 1.0$
 */
public class 基数排序 {
    public static void main(String[] args) {
        int[] arr = {2, 34, 556, 7, 8, 23, 1, 9};
        radixSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    /**
     * 获取最大值的位数
     * @param arr
     * @return
     */
    private static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    private static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i, j = 0;
        int[] help = new int[R - L + 1];
        //循环最大值的位数次(个，十，百，千......)
        for (int d = 1; d <= digit; d++) {
            //词频统计
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            //累加统计
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            //核心()
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            //交换
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }
        }
    }

    /**
     * 获得指定位上的值
     * @param x
     * @param d
     * @return
     */
    private static int getDigit(int x, int d) {
//        return (
//                   (
//                        x / ((int) Math.pow(10, d - 1))
//                   ) % 10
//               );
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }


}
