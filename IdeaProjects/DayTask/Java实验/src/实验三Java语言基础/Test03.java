package 实验三Java语言基础;

/**
 * 验证歌德巴赫猜想。一个充分大的偶数（大于或等于6）可以分解为两个素数之和
 * 将6至50之间全部偶数表示为两个素数之和并输出
 */
public class Test03 {
    public static void main(String[] args) {
        for (int i = 6; i <= 50; i += 2) {
            for (int j = 2; j < 50; j++) {
                if (isPrimeNum(j) && isPrimeNum(i - j)) {   //让此偶数的两个加数都是素数
                    System.out.print(i + "=" + j + "+" + (i - j) + " ");
                    if (i % 10 == 0) {  //分隔结果
                        System.out.println();
                    }
                    break;
                }
            }
        }
    }

    /**
     * 判断一个数是否是素数
     * @param i
     * @return
     */
    private static boolean isPrimeNum(int i) {
        for (int j = 2; j < i / 2; j++) {   //若此数能被除1和它本身外的数整除，则它不是素数，返回false
            if (i % j == 0) {
                return false;
            }
        }
        //程序能执行到此处，说明此数是素数，所以返回true
        return true;
    }
}
