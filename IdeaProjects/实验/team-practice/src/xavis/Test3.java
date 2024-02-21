package xavis;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Test3 {
    public static void main(String[] args) {
        // 加载OpenCV库
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.load("G:\\all\\IdeaProjects\\实验\\team-practice\\lib\\opencv_java450.dll");

        // 读取原始图像
        Mat src_s = Imgcodecs.imread("D:\\Download\\dip_switch_02.bmp");
        Mat src = new Mat();

        // 显示原始图像
        Core.bitwise_not(src_s, src);
        showImage(src, "原图");

        // 边缘检测算法：Sobel
        Mat edgeSobel = new Mat();
        Imgproc.Sobel(src, edgeSobel, -1, 1, 1);
        // 反转边缘图像
        Core.bitwise_not(edgeSobel, edgeSobel);
        // 显示Sobel算子边缘检测结果
        showImage(edgeSobel, "sobel算子边缘检测结果");

        // 边缘检测算法：Roberts
        Mat edgeRobert = new Mat();
        Imgproc.Sobel(src, edgeRobert, -1, 0, 1);
        // 反转边缘图像
        Core.bitwise_not(edgeRobert, edgeRobert);
        // 显示Robert算子边缘检测结果
        showImage(edgeRobert, "robert算子边缘检测结果");

        // 边缘检测算法：Laplacian
        Mat edgeLap = new Mat();
        Imgproc.Laplacian(src, edgeLap, -1);
        // 反转边缘图像
        Core.bitwise_not(edgeLap, edgeLap);
        // 显示Laplacian算子边缘检测结果
        showImage(edgeLap, "gauss算子边缘检测结果");

//        // 应用高斯滤波
//        Mat blurredImage = new Mat();
//        Imgproc.GaussianBlur(grayImage, blurredImage, new Size(5, 5), 0);
//        // 应用Canny边缘检测
//        Mat edges = new Mat();
//        Imgproc.Canny(blurredImage, edges, 50, 150); // 调整阈值以获取更好的结果
//        Core.bitwise_not(edges, edges);
        System.exit(0);
    }

    // 显示图像
    private static void showImage(Mat image, String name) {
        HighGui.imshow(name, image);
        HighGui.waitKey();
    }
}