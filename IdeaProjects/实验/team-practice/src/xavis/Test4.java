package xavis;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Test4 {
    public static void main(String[] args) {
        //加载动态链接库
        System.load("G:\\all\\IdeaProjects\\实验\\team-practice\\lib\\opencv_java450.dll");

        Mat image1 = Imgcodecs.imread("D:\\Download\\project1.bmp");
        convertDepth24to8(image1, image1);
        showImage(image1);
        sleep(500);

        Mat image2 = new Mat();
        int[] hproject = new int[10];
        int s = 0, e = 0, num = 0;
        imageProject2(image1, image2, hproject, 10, s, e, num);
        showImage(image2);
        sleep(500);

        Mat image3 = new Mat();
        int[] vproject = new int[10];
        int s1 = 0, e1 = 0, num1 = 0;
        imageProject2(image1, image3, vproject, 10, s1, e1, num1);
        showImage(image3);
        sleep(500);

        setColor(5, "red");
        showImage(image1);

        int offset = 5;
        s1 -= offset;
        s -= offset;
        e1 += offset;
        e += offset;

        Rect rect = new Rect(s1, s, e1, e);
        showRectangle(rect, image3);
    }

    private static void convertDepth24to8(Mat src, Mat dst) {
        // 将24位深度图像转换为8位深度
        Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
    }

    private static void showImage(Mat image) {
        // 在窗口中显示图像
        String windowName = "Image";
        HighGui.imshow(windowName, image);
        HighGui.waitKey();
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void imageProject2(Mat src, Mat dst, int[] project, int projectSize, int s, int e, int num) {
        // 图像投影实现
        int width = src.cols();
        int height = src.rows();

        for (int i = 0; i < projectSize; i++) {
            int count = 0;
            int sum = 0;
            int average = 0;
            for (int j = s; j < e; j++) {
                int value = (int) src.get(j, project[i])[0];
                count++;
                sum += value;
            }
            if (count > 0) {
                average = sum / count;
            }
            int startX = (int) (((double) i / projectSize) * width);
            int endX = (int) ((((double) i + 1) / projectSize) * width) - 1;
            for (int j = startX; j <= endX; j++) {
                dst.put(j, project[i], average);
            }
        }
    }

    private static void setColor(int colorIndex, String color) {
        // 设置颜色
        switch (colorIndex) {
            case 0:
                System.out.println("Setting color to Red");
                // 设置颜色为红色的代码
                break;
            case 1:
                System.out.println("Setting color to Green");
                // 设置颜色为绿色的代码
                break;
            case 2:
                System.out.println("Setting color to Blue");
                // 设置颜色为蓝色的代码
                break;
            default:
                System.out.println("Invalid color index");
                break;
        }
    }

    private static void showRectangle(Rect rect, Mat src) {
        // 在图像中显示矩形
        Mat image = new Mat();
        // 从源图像中截取矩形区域
        image = src.submat(rect);
        // 在窗口中显示截取的图像
        showImage(image);
    }
}
