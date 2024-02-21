package 实验九java输入输出;

import java.io.IOException;
import java.io.InputStream;

public class  Test01 {
    public static void main(String[] args) {
        long sum = 0;    //用来保存整数和
        System.out.print("请输入您想要输入的数据个数：");
        try {
            long n = input(System.in);   //获取输入数据的个数

            //获取所需整数数据，并对整数数据进行累加求和
            for (int i = 0; i < n;) {
                System.out.printf("请输入第%d个数据(整数)：", i + 1);
                long x = input(System.in);
                if (x != 0) {
                    sum += x;
                    i++;
                }
            }
            System.out.println(sum);    //输出求和结果
        // 捕捉相关异常
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotISIntegerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取合法的整数数据
     * @param is 标准输入流，从键盘获取输入
     * @return 返回输入的整数数据
     * @throws IOException IO异常
     */
    public static long input(InputStream is) throws IOException, NotISIntegerException {
        long[] a = new long[19];  //用来保存输入的整数数据
        int i = 0;
        //将输入的每个字节的字符数据转换为整数数据，并保存在数组a中
        for (; i < 19;) {
            //将输入的字节数据的ASCII码转减去48，若结果是0-9的数字，则说明输入的是数字
            a[i] = is.read() - 48;
            //判断是否获取的输入已到达末尾，即输入的字节是否是换行符(其ASCII码是10)
            if (a[i] != -38) {
                //判断输入的是否是数字
                if (a[i] >= 0 && a[i] <= 9) {
                    //是的话进行循环，每多一位数字，则让前面的每个数乘10，进一位，直到输入的字节不是数字
                    for (int j = 0; j < i; j++) {
                        a[j] *= 10;
                    }
                    i++;    //每保存一位数字，则i加1
                } else {    //如果输入的不是数字，则抛出异常
                    throw new NotISIntegerException();
                }
            } else {    //如果输入已到达末尾，则跳出循环
                break;
            }
        }
        long sum = 0;    //用来保存最终的整数数据
        //将数组a中每一位数字相加，最终得到的是输入的整数数据
        for (int j = 0; j < i; j++) {
            sum += a[j];
        }
        return sum;
    }
}

/**
 * 不是整数异常，输入数据不是整数数据时应该抛出的异常
 */
class NotISIntegerException extends Exception {
    public NotISIntegerException() {
        super();
    }

    @Override
    public String getMessage() {
        return "输入的不是整数!";
    }
}