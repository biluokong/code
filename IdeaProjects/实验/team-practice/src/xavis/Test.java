package xavis;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Test {
    public static void main(String[] args) {
        // 加载OpenCV库
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.load("G:\\all\\IdeaProjects\\实验\\team-practice\\lib\\opencv_java450.dll");

        // 读取原始图像
        Mat src_s = Imgcodecs.imread("D:\\Download\\dip_switch_02.bmp");
        Mat src = new Mat();
        Core.bitwise_not(src_s, src);

        // 显示原图像
        showImage("原图", src);

        // 使用Sobel算子进行边缘检测
        Mat edgesobel = new Mat();
        Imgproc.Sobel(src, edgesobel, -1, 1, 1);

        // 倒置像素
        Mat edgesobel2 = new Mat();
        Core.bitwise_not(edgesobel, edgesobel2);

        // 显示Sobel算子边缘检测结果
        showImage("Sobel算子边缘检测结果", edgesobel2);

        // 使用Robert算子进行边缘检测
        Mat edgerobert = new Mat();
        Mat robert = new Mat(2, 2, CvType.CV_32F, new Scalar(1));
        Imgproc.filter2D(src, edgerobert, -1, robert);

        // 倒置像素
        Mat edgerobert2 = new Mat();
        Core.bitwise_not(edgerobert, edgerobert2);

        // 显示Robert算子边缘检测结果
        showImage("Robert算子边缘检测结果", edgerobert);

        // 使用高斯滤波进行边缘检测
        Mat edgelap = new Mat();
        Mat gauss = new Mat(3, 3, CvType.CV_32F, new Scalar(1));
        Imgproc.filter2D(src, edgelap, -1, gauss);

        // 倒置像素
        Mat edgelap2 = new Mat();
        Core.bitwise_not(edgelap, edgelap2);

        // 显示高斯滤波边缘检测结果
        showImage("高斯滤波边缘检测结果", edgelap);
        System.exit(0);
    }

    // 显示图像
    private static void showImage(String name, Mat image) {
        HighGui.imshow(name, image);
        HighGui.waitKey();
    }
}