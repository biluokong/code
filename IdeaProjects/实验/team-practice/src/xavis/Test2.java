package xavis;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Test2 {

public static void main(String[] args) throws InterruptedException {
    //加载动态链接库
    //System.load("G:\\all\\IdeaProjects\\实验\\team-practice\\lib\\opencv_java450.dll");
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

    // 读取图像
    Mat src = Imgcodecs.imread("D:\\Download\\test14-1.bmp");

    // 显示原始图像
    HighGui.imshow("原图像", src);
    HighGui.waitKey();
    Thread.sleep(800);

    // 应用均值滤波
    Mat des1 = new Mat(src.size(), CvType.CV_8UC3);
    Imgproc.blur(src, des1, new Size(9, 9));
    HighGui.imshow("均值滤波", des1);
    HighGui.waitKey();
    Thread.sleep(800);

    // 应用中值滤波
    Mat med = new Mat();
    Imgproc.medianBlur(src, med, 3);
    HighGui.imshow("中值率波", med);
    HighGui.waitKey();
    Thread.sleep(800);

    // 应用高斯滤波
    Mat gauss = new Mat();
    Imgproc.GaussianBlur(src, gauss, new Size(3, 3), 0);
    HighGui.imshow("高斯滤波", gauss);
    HighGui.waitKey();
    Thread.sleep(800);

    // 应用高斯边缘检测
    Mat gaussedge = new Mat();
    Imgproc.Canny(src, gaussedge, 50, 150);
    HighGui.imshow("高斯边缘检测", gaussedge);
    HighGui.waitKey();
    System.exit(0);
}
}