import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class 判断java文件中是否有某字符串 {
    public static void main(String[] args) {
        try {
//			String filePath=System.getProperty("user.dir");
//			System.out.println(filePath);
            FileReader fr = new FileReader("javase/src/多线程/DeadLock.java");
            StringBuilder sb = new StringBuilder();
            char[] c = new char[1024];
            int len = 0;
            while( (len = fr.read(c)) != -1){
                sb.append(c, 0, len);
            }
            String str = sb.toString();
            boolean result1 = str.contains("start");
            boolean result2 = str.contains("run");
            boolean result3 = str.contains("sleep");
            if((result1 || result3)&&result2 ){
                System.out.println("有start()或者sleep()方法");
                return;
            } else{
                System.out.println("没有start()或者sleep()方法");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}