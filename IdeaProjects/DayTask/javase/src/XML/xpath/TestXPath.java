package XML.xpath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class TestXPath {
    /**
     * 绝对路径
     */
    @Test
    public void parse01() throws DocumentException {
        //1、创建解析器对象
        SAXReader saxReader = new SAXReader();
        //2、把XML加载成Document对象
        Document document = saxReader.read(TestXPath.class.getResource("/XML/hello_world.xml"));
        Element root = document.getRootElement();
        //3、检索全部的名称
        //List<Node> nameNodes = document.selectNodes("/书架/书/书名");  //绝对路径
        //List<Node> nameNodes = root.selectNodes("./书架/书/书名");  //相对路径
        List<Node> nameNodes = document.selectNodes("//书名");  //全文检索
        for (Node nameNode : nameNodes) {
            Element nameEle = (Element) nameNode;
            System.out.println(nameEle.getTextTrim());
        }
        System.out.println(nameNodes.size());
        System.out.println(document.getRootElement().element("书").element("书名").getTextTrim());
    }
}
