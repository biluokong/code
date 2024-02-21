import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CleanMdImg {
    private static String filePath; // 选择的markdown文件的路径

    public static void main(String[] args) {
        // 打开文件下载窗口选择文件，从而获得markdown文件的路径
        FileDialog dialog = new FileDialog(new JFrame());
        dialog.setVisible(true);
        if (dialog.getDirectory() == null || dialog.getFile() == null)
            System.exit(1);
        else
            filePath = dialog.getDirectory() + dialog.getFile();

        // 构建副本路径和图片保存路径
        String imgPath = filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.length() - 3) + "_img";
        String destPath = dialog.getDirectory() + "\\" + imgPath;

        try {
            // 将markdown文件读入内存，保存到字符串变量stringBuilder中
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null)
                stringBuilder.append(line).append("\n");
            br.close();

            // 获得图片网络地址，并从网络上下载图片到本地；最后把markdown文档的图片标签换成本地路径
            String mdContent = stringBuilder.toString();
            Pattern pattern = Pattern.compile("!\\[.*?]\\((.*?)\\)"); // 匹配表达式
            Matcher matcher = pattern.matcher(mdContent);    // 构建匹配器
            File dir = new File(destPath);
            if (!dir.exists())
                dir.mkdirs(); // 创建图片存储位置的文件夹
            while (matcher.find()) {
                String imgUrl = matcher.group(1);   // 匹配匹配器第一个括号里的内容
                InputStream inputStream = new FileInputStream(dialog.getDirectory() + imgUrl);
                ReadableByteChannel rbc = Channels.newChannel(inputStream); // 同步nio
                // 图片名称
                int index = imgUrl.lastIndexOf("\\");
                String imgName = imgUrl.substring(index != -1 ? index : imgUrl.lastIndexOf("/"));
                FileOutputStream fos = new FileOutputStream(destPath + imgName);
                fos.getChannel().transferFrom(rbc, 0L, Long.MAX_VALUE); // 写入图片文件
                fos.close();
                mdContent = mdContent.replaceFirst(imgUrl, imgPath + imgName);
            }

            JOptionPane.showMessageDialog(null, "任务完成！");
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "任务失败！", "IO异常", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(1);
    }
}
