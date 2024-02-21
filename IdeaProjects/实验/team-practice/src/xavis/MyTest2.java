package xavis;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class MyTest2 {
    public static void main(String[] args) {
        //加载动态链接库
        System.load("G:\\all\\IdeaProjects\\实验\\team-practice\\lib\\opencv_java450.dll");

        // 加载图像
        String filename = "D:\\Download\\test14-1.bmp";
        Mat image = Imgcodecs.imread(filename);
        HighGui.imshow("Image", image);
        HighGui.waitKey(0);

        // 将图像转换为灰度
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

        // 设置图像阈值
        Mat thresholdImage = new Mat();
        Imgproc.threshold(grayImage, thresholdImage, 150, 255, Imgproc.THRESH_BINARY);
        HighGui.imshow("thresholdImage", thresholdImage);
        HighGui.waitKey(0);

        // 反转图像
        Mat invertedImage = new Mat();
        Core.bitwise_not(thresholdImage, invertedImage);
        HighGui.imshow("invertedImage", invertedImage);
        HighGui.waitKey(0);

        // 应用外部边缘检测
        Mat edgeImage = new Mat();
        Imgproc.Canny(invertedImage, edgeImage, 100, 200);
        HighGui.imshow("edgeImage", edgeImage);
        HighGui.waitKey(0);

        // 查找边的边界矩形
        Rect rect = Imgproc.boundingRect(edgeImage);

        // 在原始图像上绘制矩形
        Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 2);

        // 找到边缘的轮廓
        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(edgeImage, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
        HighGui.imshow("Image", image);
        HighGui.waitKey(0);

        // 查找最大轮廓
        MatOfPoint largestContour = null;
        double largestContourArea = 0;
        for (MatOfPoint contour : contours) {
            double contourArea = Imgproc.contourArea(contour);
            if (contourArea > largestContourArea) {
                largestContour = contour;
                largestContourArea = contourArea;
            }
        }

        // 将椭圆拟合到最大轮廓
        MatOfPoint2f largestContour2f = new MatOfPoint2f(largestContour.toArray());
        RotatedRect ellipse = Imgproc.fitEllipse(largestContour2f);
        Point center = ellipse.center;
        double majorAxis = ellipse.size.height;
        double minorAxis = ellipse.size.width;
        double angle = ellipse.angle;

        // 在原始图像上绘制椭圆和中心点
        Imgproc.ellipse(image, center, new Size(majorAxis / 2, minorAxis / 2), angle, 0, 360, new Scalar(0, 255, 0), 2);
        Imgproc.drawMarker(image, center, new Scalar(0, 255, 0), Imgproc.MARKER_CROSS, 20, 2);

        // 在窗口中显示最终图像
        HighGui.imshow("Image", image);
        HighGui.waitKey(0);
        System.exit(0);
    }
}