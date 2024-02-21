package 常用框架.commons_io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommonsIODemo01 {
    public static void main(String[] args) throws IOException {
        //1、完成文件复制
//        IOUtils.copy(new FileInputStream("D:\\图片\\view01.jpg"), new FileOutputStream("D:\\图片\\view02.jpg"));

        //2、完成文件复制到某个文件夹下
//        FileUtils.copyFileToDirectory(new File("D:\\图片\\view01.jpg"), new File("D:\\"));

        //3、完成文件夹复制到某个文件夹下
//        FileUtils.copyDirectoryToDirectory(new File("D:\\图片"), new File("D:\\图片\\复制"));
        FileUtils.deleteDirectory(new File("D:\\图片\\复制"));
        //4、JDK7 也做了一个复制方法：NIO
        Files.copy(Path.of("D:\\图片\\view01.jpg"), Path.of("D:\\图片\\view02.jpg"));
//        Files.deleteIfExists(Path.of("D:\\图片\\复制"));  //删除空的
    }
}
