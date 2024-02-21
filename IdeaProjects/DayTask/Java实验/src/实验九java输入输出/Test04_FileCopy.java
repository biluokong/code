package 实验九java输入输出;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Test04_FileCopy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入源文件(夹)名(绝对路径)：");
        File src = new File(input.nextLine());
        while (true) {
            System.out.println("请输入目标文件夹名(绝对路径)：");
            File dest = new File(input.nextLine());
            //判断目标文件名是否是目录
            if (dest.isDirectory()) {
                //如果是目录就调用方法进行文件复制

                //方法一
                fileCopy01(src, dest);

                //方法二
                //fileCopy02(src, dest);

                //方法三
                /*try {
                    fileCopy03(src, dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                break;
            } else {
                //如果不是就请用户重新输入文件夹名
                System.out.println("输入错误，请重新输入文件夹名：");
            }
        }
    }

    /**
     * 对文件进行复制的方法，只需调用Files.walkFileTree()方法实现，不需要递归调用
     * @param src 源文件
     * @param dest 目标文件
     * @throws IOException IO异常
     */
    public static void fileCopy03(File src, File dest) throws IOException {
        //调用Files.walkFileTree()方法进行文件的遍历
        Files.walkFileTree(src.toPath(), new SimpleFileVisitor<Path>(){
            //访问文件目录里面之前调用的方法，即访问文件目录时调用的方法
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在复制文件夹：" + dir);

                //调用Files.copy()方法进行文件夹的复制
                //第一个参数是要复制的当前文件夹
                //第二个参数是将当前文件夹与源文件的相对路径和目标文件的绝对路径进行拼接后所得的复制位置的绝对路径
                //Files.copy(dir, dest.toPath().resolve(src.toPath().getParent().relativize(dir)));

                //调用Files里的createDirectory()方法进行文件夹的创建
                //Files.createDirectory(dest.toPath().resolve(src.toPath().getParent().relativize(dir)));

                //调用File里的mkdir()方法进行文件夹的创建
                //dest.toPath().resolve(src.toPath().getParent().relativize(dir)).toFile().mkdir();

                //返回FileVisitResult.CONTINUE表示继续访问
                return FileVisitResult.CONTINUE;
            }

            //访问普通文件时调用的方法
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在复制文件：" + file);
                //调用Files.copy()方法进行文件的复制
                //第一个参数是要复制的当前文件
                //第二个参数是将当前文件与源文件的相对路径和目标文件的绝对路径进行拼接后所得的复制位置的绝对路径
                Files.copy(file, dest.toPath().resolve(src.toPath().getParent().relativize(file)));
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * 对文件进行复制的方法，递归调用方法
     * 用Files.copy()方法和File类中的方法实现
     * @param src 源文件
     * @param dest 目标文件
     */
    public static void fileCopy02(File src, File dest) {
        try {
            //将目标文件的绝对路径与源文件名进行拼接，即得到原文件的具体复制绝对路径
            Path path = dest.toPath().resolve(src.toPath().getFileName());
            System.out.println(path);   //输出原文件的具体复制绝对路径
            //复制文件到目标文件夹中
            Files.copy(src.toPath(), path);
            //更新目标文件名
            dest = new File(path.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //判断源文件是否是目录
        if (src.isDirectory()) {
            //如果目录不为空
            if (src.listFiles() != null) {
                //获取源文件夹下的所有文件
                File[] files = src.listFiles();
                //遍历所有文件
                for (File file : files) {
                    //递归调用方法进行文件复制
                    fileCopy02(file, dest);
                }
            }
        } else {    //如果源文件是文件，代表已经到达文件的最后一层，不需要再递归调用
            //退出递归
            return;
        }
    }

    public static void fileCopy01(File scr, File dest) {
        //获取原文件复制位置的绝对路径，用目标文件的绝对路径和源文件名拼接而成
        String path = dest.getPath() + "\\" + scr.getName();
        System.out.println(path);   //输出此绝对路径
        //更新目标文件
        File destPath = new File(path);
        //如果是目录
        if (scr.isDirectory()) {
            //创建相应的目录到具体地复制位置上
            destPath.mkdir();
            //如果该目录下不为空
            if (scr.listFiles() != null) {
                //获取该目录下所有普通文件和目录
                File[] files = scr.listFiles();
                //变量目录下的所有普通文件和目录
                for (File file : files) {
                    //递归调用方法进行文件的复制
                    fileCopy01(file, destPath);
                }
            }
        //如果是普通文件的话，就进行文件的复制
        } else {
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(scr);  //输入流对象，获得源文件数据
                os = new FileOutputStream(destPath);    //输出流对象，将数据写到目标文件中
                byte[] bytes = new byte[1024 * 1024];   //一次最多读的数据字节量
                int len = 0;    //一次可读到的字节数目
                //循环写入数据，直到源文件数据全部写入目标文件
                while ((len = is.read(bytes)) != -1) {  //len不等于-1代表读到了数据，就继续读
                    os.write(bytes, 0, len);    //将读到的数据写入文件
                }
                os.flush(); //在流通道关闭前，刷新。把剩余数据全部写入文件。
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
    }
}
