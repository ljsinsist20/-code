public class 异或_面试题 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 5, 3, 3, 4, 4};//存在一个出现奇数次
//        int eor = find(arr);
//        System.out.println(eor);


        // TODO 缺少正确解法
        int[] arr2 = {1, 1, 2, 3, 3, 4, 4, 5, 5, 90};//存在一个出现奇数次
        int eor2 = find2(arr2);
        System.out.println(eor2);

        // TODO 2^4=6???
//        System.out.println(2^5);
    }

    private static int find(int[] arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        return eor;
    }

    private static int find2(int[] arr2) {
        int eor2 = 0;
        for (int num : arr2) {
            eor2 ^= num;
        }

        int rightOne = eor2 & (~eor2 + 1);
        int onlyOne = 0;
        for (int cur : arr2) {
            // TODO ==1? ==0? ==rightOne?
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + "-" +(eor2 ^ onlyOne));

        return eor2;
    }

}
