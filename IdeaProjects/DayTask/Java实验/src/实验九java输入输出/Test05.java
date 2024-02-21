package 实验九java输入输出;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("你想要加密的文件名(绝对路径)：");
        String fileName = input.nextLine();
        // 创建一个文件输入流
        InputStream is = null;
        String str = "";    // 存放字符串形式的文件内容
        try {
            //获取文件名为输入文件名的文件输入流对象
            is = new FileInputStream(fileName);
            //创建一个字节数组，储存文件内容
            byte[] bytes = new byte[1024 * 1024];
            int len = 0;    // 存放读取到的字节数
            while ((len = is.read(bytes)) != -1) {
                // 将读取到的字节数据转换成字符串
                str += new String(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            input.close();
            // 关闭输入流
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(str);    // 打印文件内容

        //将对应加密字母存入一个字符串数组
        String encryptionTable = "TOIANDEGHZBKFJMCLPYVXQRWUS";

        //将字符串的相应字符转换为对应加密字符
        //创建一个正则表达式对象，用来匹配字符串中的字符
        Pattern p = Pattern.compile("[A-Za-z]");
        //创建一个匹配器
        Matcher m = p.matcher(str);
        //将字符串中的字符替换为对应加密字符
        while (m.find()) {  // 如果匹配到字符
            //将匹配到的字符先用temp存储
            String temp = m.group();
            //将匹配到的大写字母替换为对应加密字母
            if (temp.charAt(0) >= 'A' && temp.charAt(0) <= 'Z') {
                str = str.replaceFirst(temp, encryptionTable.charAt(temp.charAt(0) - 'A') + "");
            //将匹配到的小写字母替换为对应加密字母
            } else {
                str = str.replaceFirst(temp, (char) (encryptionTable.charAt(temp.charAt(0) - 'a') + 32) + "");
            }
        }

        System.out.println(str);    // 打印加密后的文件内容
        //将加密后的文件内容重新写入文件
        //创建一个文件输出流
        OutputStream os = null;
        try {
            //获取文件名为输出文件名的文件输出流对象
            os = new FileOutputStream(fileName);
            //将加密后的文件内容写入文件
            os.write(str.getBytes());
            //刷新
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}