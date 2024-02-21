import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class 翻译默写 {
    public static void main(String[] args) throws IOException {
        //把C:\Users\797799421\Desktop\本部AB级翻译复习资料.docx中的字符都读出来
        FileReader fr = new FileReader("C:\\Users\\797799421\\Desktop\\测试工具\\翻译.txt");
        int ch = 0, count = 0;
        String str = "";
        while ((ch = fr.read()) != -1) {
            str += (char) ch;
        }
        Scanner sc = new Scanner(System.in);
        String[] s = str.split("\n");
        boolean flag = false;
        System.out.println("请输入开始句子序号：");
        int start = sc.nextInt();
        for (int i = 0; i < s.length; i++) {
            if (i % 2 == 0) {
                System.out.println(s[i]);
                if (start > 0)
                    start--;
            } else if (start == 0) {
                while (true) {
                    System.out.println("请输入英文翻译：");
                    String answer = "";
                    if (!flag) {
                        answer = sc.nextLine();
                        if ("".equals(answer))
                            answer = sc.nextLine();
                        if (answer.matches("^\\d+")) {
                            count = Integer.parseInt(answer);
                            flag = true;
                        }
                    }
                    if (flag) {
                        count--;
                        if (count == 0)
                            flag = false;
                        break;
                    }
                    if (s[i].split("\r")[0].equals(answer)) {
                        System.out.println("太棒了，默写正确！");
                        break;
                    } else {
                        System.out.println("默写错误！原句为：\n" + s[i]);
                    }
                }
            }
        }
    }
}