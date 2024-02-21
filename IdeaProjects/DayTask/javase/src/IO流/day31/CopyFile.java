package IO流.day31;
/*拷贝目录：
	将某拷贝到C盘根下....
	需要使用到：
		FileInputStream
		FileOutputStream
		File
	可能需要使用到递归。你尝试实现一下！*/

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入源目录：");
        // 拷贝源
        File srcFile = new File(input.next());
        System.out.println("请输入目标目录：");
        // 拷贝目标
        File destFile = new File(input.next());
        // 调用方法拷贝
        copyDir(srcFile, destFile);
    }

    private static void copyDir(File srcFile, File destFile) {
        if (srcFile.isFile()) {    //判断srcFile是否是文件，是的话就开始拷贝，结束递归
            FileInputStream in = null;
            FileOutputStream out = null;
            try {
                in = new FileInputStream(srcFile);
                String path = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() :
                        destFile.getAbsolutePath() + "\\") + srcFile.getAbsolutePath().substring(3);
                out = new FileOutputStream(path);
                byte[] bytes = new byte[1024 * 1024];
                int readCount = 0;
                while ((readCount = in.read(bytes)) != -1) {
                    out.write(bytes, 0, readCount);
                }
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
        //获取子目录
        File[] files = srcFile.listFiles();
        for (File file : files) {
            // 获取所有文件的（包括目录和文件）绝对路径
            //System.out.println(file.getAbsolutePath());
            if (file.isDirectory()) {    //判断是否是目录
                // 新建对应的目录
                //System.out.println(file.getAbsolutePath())
                String srcDir = file.getAbsolutePath();
                String desDir = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() :
                        destFile.getAbsolutePath() + "\\") + file.getAbsolutePath().substring(3);  //或者srcDir.substring(3);
                File newFile = new File(desDir);
                if (!newFile.exists()) {    //测试此抽象路径名表示的文件或目录是否存在
                    //如果不存在，创建此抽象路径名指定的目录，包括任何必需但不存在的父目录。
                    newFile.mkdirs();
                }
            }
            copyDir(file, destFile);
        }
    }
}
