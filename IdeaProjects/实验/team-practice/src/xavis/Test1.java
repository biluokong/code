package xavis;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Test1 {
    public static void main(String[] args) {

        //加载动态链接库
        System.load("G:\\all\\IdeaProjects\\实验\\team-practice\\lib\\opencv_java450.dll");
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // 读取图像
        String filePath = "D:\\Download\\gongjian1.bmp";
        Mat image = Imgcodecs.imread(filePath);

        // 显示图像
        HighGui.imshow("原始图像", image);
        HighGui.waitKey(0); // 等待用户操作，0表示无限等待

        // 阈值转换（将图像二值化）
        Mat image1 = new Mat();
        Imgproc.threshold(image, image1, 80, 255, Imgproc.THRESH_BINARY);
        HighGui.imshow("阈值转换后的图像", image1);
        HighGui.waitKey(0); // 等待用户操作，0表示无限等待

        // 点反传（将白色区域变成黑色，黑色区域变成白色）
        Mat image2 = new Mat();
        Core.bitwise_not(image1, image2);
        HighGui.imshow("点反传后的图像", image2);
        HighGui.waitKey(0); // 等待用户操作，0表示无限等待

        // 边缘获取（检测边缘）
        Mat image3 = new Mat();
        Imgproc.Canny(image2, image3, 100, 200);    //默认背景黑色，边缘白色
        Core.bitwise_not(image3, image3);           //反转颜色，让背景变为白色，边缘变为黑色
        HighGui.imshow("边缘检测后的图像", image3);
        HighGui.waitKey(0); // 等待用户操作，0表示无限等待
        System.exit(0);
    }
}