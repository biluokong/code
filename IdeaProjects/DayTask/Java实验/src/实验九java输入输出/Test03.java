package 实验九java输入输出;

import java.io.*;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你要读取文件的文件名(绝对路径完整文件名)：");
        // 获取用户输入的文件名
        String fileName = input.nextLine();
        // 创建输入流对象
        InputStream file = null;
        //保存文件内容的字符串
        String str = "";
        try {
            //获取文件输入流对象，读取文件名为输入文件名的文件
            file = new FileInputStream(fileName);
            //创建一个字节数组，用于存放读取的字节
            byte[] b = new byte[1024];
            int len = 0;    //记录读取的字节数
            //读取文件，并将读取的内容存放到字节数组中
            while ((len = file.read(b)) != -1) {
                //将字节数组转换成字符串
                str += new String(b, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭输入流
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //输出文件内容
        System.out.println(str);
        //调用方法，选择是否修改文件内容
        selectModify(input, fileName);
    }

    /**
     * 选择是否修改文件内容，如果修改，则修改文件内容，否则不修改
     * @param input 输入流对象
     * @param fileName 修改数据的文件的文件名
     */
    public static void selectModify(Scanner input, String fileName) {
        while (true) {
            System.out.println("请问您是否想要修改文件内容？(Y/N)");
            //获取用户输入的是否修改文件内容的选择
            String choice = input.nextLine();
            //如果用户选择修改文件内容
            if("Y".equals(choice)) {
                System.out.println("请输入您要修改的内容：");
                //获取用户输入的修改的内容
                String str = input.nextLine();
                //创建输出流对象
                OutputStream file = null;
                try {
                    //获取文件输出流对象，将文件名为输入文件名的文件内容修改为用户输入的内容
                    file = new FileOutputStream(fileName);
                    //将用户输入的内容转换成字节数组
                    byte[] b = str.getBytes();
                    //将字节数组写入文件
                    file.write(b);
                    //刷新输出流，让通道里剩余的数据强制写入文件
                    file.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //关闭输出流
                    if (file != null) {
                        try {
                            file.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            } else if ("N".equals(choice)) {
                return;
            } else {
                System.out.println("输入错误，请重新输入！");
            }
        }
    }
}
