package dom4j_parseXML;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.TransformerConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class ParseXMLHandler {

  /**
   * 解析 xml  修改 xml 内容 ，在 把 xml 保存
   * @param args
   * @throws DocumentException
   * @throws TransformerConfigurationException
   */
  public static void main(String[] args) throws Exception {
    /* 解析xml字符串 */
    /*
     * String xmlStr=
     * "<html><head><title>标题</title></head><body id='bodyID'>哈哈</body></html>";
     * Document document=DocumentHelper.parseText(xmlStr); Element
     * element=document.getRootElement();//获取根节点 String
     * title=element.element("head").element("title").getText();
     * System.out.println(title); String
     * bodyID=element.element("body").attributeValue("id");
     * System.out.println(bodyID);
     */

    InputStream pathXMLStream = ParseXMLHandler.class.getClassLoader()
        .getResourceAsStream("person.xml"); //加载和 。class 在同一目录下的文件
    SAXReader reader = new SAXReader();  //解析 流
    Document document = reader.read(pathXMLStream);  //解析xml 
    Element root = document.getRootElement();// 获取根节点persons
    List list = root.elements("person"); //跟节点下的 所有 person元素
    Iterator ite = list.iterator(); //迭代

    while (ite.hasNext()){ 
      Element element = (Element) ite.next(); //其中一个元素
      element.element("name").setText("李四");  //这个元素下的 name  的文本 为李四
      System.out.println(element.attributeValue("cardno") + ":"
          + element.element("name").getText());
      
    }
    // 添加一个person
    Element personElement = root.addElement("person"); //在一个 persons 下添加 一个person 
    personElement.addAttribute("cardno", "1009");  //属性 是 
    Element nameElement = personElement.addElement("name"); //name 是
    nameElement.setText("zyg");
    Element ageElement = personElement.addElement("age");
    ageElement.setText("23");
    Element addressElement = personElement.addElement("address");
    addressElement.setText("北京");
    Element birthdayElement = personElement.addElement("birthday");
    birthdayElement.setText("19871010");

    // 重新将数据流写入xml文件；
    String path = ParseXMLHandler.class.getResource("/").getPath();// 获取项目根目录D:/workspace/8.12DomParseXml/bin/
    System.out.println(path);
    OutputFormat format = OutputFormat.createPrettyPrint(); // 格式化
    format.setEncoding("utf-8");
    XMLWriter writer2 = new XMLWriter(new FileWriter(new File(path+ "person.xml")), format);
    writer2.write(document); // 输出到文件
    writer2.close();
  }

}
