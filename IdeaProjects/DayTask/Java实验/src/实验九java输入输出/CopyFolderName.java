package 实验九java输入输出;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//在电脑D盘创建一个名为FileList的文本文件，将D盘下所有文件及文件夹名称保存到这个文件中。
public class CopyFolderName {
    public static void main(String[] args) {
        try {
            //调用方法将指定原目录下的所有文件及文件夹名称保存到指定目标文件中
            copyFolderName("D:\\", "D:\\FileList.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将指定原目录下的所有文件及文件夹名称保存到指定目标文件中
     * @param originalFile 原目录
     * @param targetFile 目标文件
     * @throws FileNotFoundException
     */
    public static void copyFolderName(String originalFile, String targetFile) throws FileNotFoundException {
        //创建目标文件并获取与文件的连接，从而可以将文件内容写入到文件中
        FileOutputStream fos = new FileOutputStream(targetFile, true);
        //创建原目录对象
        File file = new File(originalFile);
        //调用方法将指定原目录下的所有文件及文件夹名称保存到指定目标文件中
        copyName(fos, file);
    }

    /**
     * 递归调用方法将指定原目录下的所有文件及文件夹名称保存到指定目标文件中
     * @param fos 目标文件的连接
     * @param file 原目录对象
     */
    public static void copyName(FileOutputStream fos, File file) {
        //判断原目录对象是否是文件夹
        if (file.isDirectory()) {
            //将文件夹名称写入到目标文件中
            try {
                fos.write(file.getName().getBytes());
                fos.write("\r\n".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            //获取文件夹下的所有文件及文件夹对象
            File[] files = file.listFiles();

            //判断文件夹下是否有文件或文件夹
            if (files != null) {
                //遍历文件夹下的所有文件及文件夹对象
                for (File f : files) {
                    //调用方法将指定原目录下的所有文件及文件夹名称保存到指定目标文件中
                    copyName(fos, f);
                }
            }
        } else {    //如果原目录对象是文件
            //将文件名称写入到目标文件中
            try {
                fos.write(file.getName().getBytes());
                fos.write("\r\n".getBytes());
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
    }
}
