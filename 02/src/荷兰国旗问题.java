public class 荷兰国旗问题 {
    public static void main(String[] args) {
        int[] arr = {2, 34, 556, 7, 5, 5, 8, 1, 9};
        int[] arr_2 = {2, 34, 556, 7, 5, 5, 8, 1, 9};
        int[] arr_3 = {2, 34, 556, 7, 5, 5, 8, 1, 9};

        // 问题一
        int num = 5;
            //基本解法
        find(arr, num);
        System.out.println("基本------------------------------");
            //进阶解法(自研版-左右)
        find_plus(arr_2, num);
        System.out.println("自研版-左右------------------------------");

        // 问题二(荷兰国旗问题)
            //进阶解法(自研版-左中右)
        find_plus_plus(arr_3, num);
        for (int i : arr_3) {
            System.out.println(i);
        }
        System.out.println("自研版-左中右------------------------------");
    }
    private static void find_plus_plus(int[] arr, int num) {
        int l_area = -1;
        int r_area = arr.length;
        int x = 0;
        /*two*/
        while (x < r_area) {
            if (arr[x] < num) {
                l_area++;
                swap(arr, x, l_area);
                x++;
            } else if (arr[x] == num) {
                x++;
            } else {
                r_area--;
                swap(arr, x, r_area);
            }
        }
        /*one*/
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[x] < num) {
//                l_area++;
//                swap(arr, x, l_area);
//                x++;
//            } else if (arr[x] == num) {
//                x++;
//            } else {
//                r_area--;
//                swap(arr, x, r_area);
//            }
//            if (x >= r_area) {
//                return;
//            }
//        }
    }

    private static void swap(int[] arr, int x, int y) {
        int flag = 0;
        flag = arr[x];
        arr[x] = arr[y];
        arr[y] = flag;
    }

    private static void find_plus(int[] arr, int num) {
        int area = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                area++;
                //同一位置不可使用
//                arr[i] = arr[i] ^ arr[area];
//                arr[area] = arr[i] ^ arr[area];
//                arr[i] = arr[i] ^ arr[area];
                int flag = 0;
                flag = arr[i];
                arr[i] = arr[area];
                arr[area] = flag;
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void find(int[] arr, int num) {
        int[] arrNew = new int[arr.length];
        int L = 0;
        int R = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                arrNew[L++] = arr[i];
            } else {
                arrNew[R--] = arr[i];
            }
        }
        for (int i : arrNew) {
            System.out.println(i);
        }
    }
}
