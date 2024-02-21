package XML.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用Dom4j解析xml文件
 */
public class TestDom4j {
    public static void main(String[] args) throws DocumentException {
        //1、创建一个Dom4j的解析对象
        SAXReader saxReader = new SAXReader();

        //2、把xml文件加载到内存中得到一个Document对象
        //Document document = saxReader.read("javase/src/XML/hello_world.xml");//根据模块名获取，可能模块名被修改
        //用Dom4j里的方法，直接从src下找xml文件
        Document document = saxReader.read(SAXReader.class.getResource("/XML/hello_world.xml"));

        //3、获取根元素对象
        Element root = document.getRootElement();
        System.out.println(root.getName());
    }
}
