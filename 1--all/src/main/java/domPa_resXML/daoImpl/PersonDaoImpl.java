package domPa_resXML.daoImpl;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import domPa_resXML.dao.PersonDao;
import domPa_resXML.entity.Person;

public class PersonDaoImpl implements PersonDao {

  /**
   * 查询数据
   * */
  public List<Person> selectPersonList(String xmlPath) throws Exception {
    List<Person> list = new ArrayList<Person>();
    // 创建解析工厂
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory
        .newInstance();
    // 创建解析器
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    InputStream inputStream = PersonDaoImpl.class.getClassLoader()
        .getResourceAsStream(xmlPath);
    Document document = builder.parse(inputStream);// 通过parse解析，输入流，返回文本对象；
    Element root = document.getDocumentElement();// 获取根节点；persons标签节点；
    // System.out.println(root.getTagName());//getTagName 获取节点名称；
    NodeList nodeList = root.getElementsByTagName("person");// 获取根节点下面所有person节点集合
    for (int i = 0; i < nodeList.getLength(); i++){// 遍历每一个节点；person
      Person person = new Person();
      Element personElement = (Element) nodeList.item(i);// 将node节点，转为Element对象
      String cardno = personElement.getAttribute("cardno");// 获取person的cardno属性值；

      Element nameElement = (Element) personElement
          .getElementsByTagName("name").item(0);
      String name = nameElement.getNodeValue();// 获取name中的文本

      Element ageElement = (Element) personElement.getElementsByTagName("age")
          .item(0);
      String age = ageElement.getNodeValue();// 获取age中的文本

      Element addressElement = (Element) personElement.getElementsByTagName(
          "address").item(0);
      String address = addressElement.getNodeValue();// 获取address中的文本

      Element birthdayElement = (Element) personElement.getElementsByTagName(
          "birthday").item(0);
      String birthday = birthdayElement.getNodeValue();// 获取birthday中的文本
      // 格式化日期；
      SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
      Date day = format.parse(birthday);
      format = new SimpleDateFormat("yyyy-MM-dd");
      birthday = format.format(day);

      person.setCardno(cardno);
      person.setName(name);
      person.setAge(Integer.parseInt(age));
      person.setAddress(address);
      person.setBirthday(birthday);

      list.add(person);
    }

    return list;
  }

  /**
   * 添加数据
   * 
   * @throws Exception
   * */
  @Override
  public void addPerson(Person person, String xmlPath) throws Exception {
    // 创建解析工厂
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory
        .newInstance();
    // 创建解析器
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    InputStream inputStream = PersonDaoImpl.class.getClassLoader()
        .getResourceAsStream(xmlPath);
    Document document = builder.parse(inputStream);// 通过parse解析，输入流，返回文本对象；
    Element root = document.getDocumentElement();// 获取根节点；persons标签节点；
    if (person != null){
      Element personElement = document.createElement("person");// 创建person节点；
      personElement.setAttribute("cardno", person.getCardno());// 为person节点属性cardno赋值；

      Element nameElement = document.createElement("name");// 创建name节点;
      nameElement.setNodeValue(person.getName());

      Element addressElement = document.createElement("address");// 创建name节点;
      addressElement.setNodeValue(person.getAddress());

      Element ageElement = document.createElement("age");// 创建name节点;
      ageElement.setNodeValue(person.getAge().toString());

      Element birthdayElement = document.createElement("birthday");// 创建name节点;
      birthdayElement.setNodeValue(person.getBirthday());

      // person中方name/age/address/birthday元素
      personElement.appendChild(nameElement);
      personElement.appendChild(ageElement);
      personElement.appendChild(addressElement);
      personElement.appendChild(birthdayElement);

      // person放入根节点persons中
      root.appendChild(personElement);
      // 重新将数据流写入xml文件；
      TransformerFactory tsfactory = TransformerFactory.newInstance();
      Transformer transform = tsfactory.newTransformer();
      String path = PersonDaoImpl.class.getResource("/").getPath();// 获取项目根目录D:/workspace/8.12DomParseXml/bin/
      System.out.println(path);
      File file = new File(path + xmlPath);
      transform.transform(new DOMSource(document), new StreamResult(file));
    }

  }

  /**
   * 修改数据 （根据cardno修改指定该对象）
   * */
  @Override
  public void updatePerson(Person person, String xmlPath) throws Exception {
    // 创建解析工厂
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory
        .newInstance();
    // 创建解析器
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    InputStream inputStream = PersonDaoImpl.class.getClassLoader()
        .getResourceAsStream(xmlPath);
    Document document = builder.parse(inputStream);// 通过parse解析，输入流，返回文本对象；
    Element root = document.getDocumentElement();// 获取根节点；persons标签节点；
    NodeList nodeList = root.getElementsByTagName("person");
    if (person != null){
      for (int i = 0; i < nodeList.getLength(); i++){
        Element personElement = (Element) nodeList.item(i);// person节点；
        if (person.getCardno().equals(personElement.getAttribute("cardno"))){
          if (person.getName() != null && !person.getName().equals("")){// 修改name
            personElement.getElementsByTagName("name").item(0)
                .setNodeValue(person.getName());
          }
          if (person.getAge() != null){// 修改年龄
            personElement.getElementsByTagName("age").item(0)
                .setNodeValue(person.getAge().toString());

          }
          if (person.getAddress() != null && !person.getAddress().equals("")){// 修改name
            personElement.getElementsByTagName("address").item(0)
                .setNodeValue(person.getAddress());
          }
          if (person.getBirthday() != null && !person.getBirthday().equals("")){// 修改name
            personElement.getElementsByTagName("birthday").item(0)
                .setNodeValue(person.getBirthday());
          }
        }

      }
    }

    // 重新将数据流写入xml文件；
    TransformerFactory tsfactory = TransformerFactory.newInstance();
    Transformer transform = tsfactory.newTransformer();
    String path = PersonDaoImpl.class.getResource("/").getPath();// 获取项目根目录D:/workspace/8.12DomParseXml/bin/
    System.out.println(path);
    File file = new File(path + xmlPath);
    transform.transform(new DOMSource(document), new StreamResult(file));

  }

  /**
   * 删除数据（根据cardno删除）
   * 
   * @throws Exception
   * */
  @Override
  public void deletePerson(String cardno, String xmlPath) throws Exception {
    // 创建解析工厂
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory
        .newInstance();
    // 创建解析器
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    InputStream inputStream = PersonDaoImpl.class.getClassLoader()
        .getResourceAsStream(xmlPath);
    Document document = builder.parse(inputStream);// 通过parse解析，输入流，返回文本对象；
    Element root = document.getDocumentElement();// 获取根节点；persons标签节点；
    NodeList nodeList = root.getElementsByTagName("person");// 获取所有根节点下面的person节点集合
    for (int i = 0; i < nodeList.getLength(); i++){
      Element personElement = (Element) nodeList.item(i);// 获取每个person节点；
      String targetCardno = personElement.getAttribute("cardno");// 获取person节点属性
                                                                 // cardno
      if (cardno.equals(targetCardno)){
        root.removeChild(personElement);
      }
    }

    // 重新将数据流写入xml文件；
    TransformerFactory tsfactory = TransformerFactory.newInstance();
    Transformer transform = tsfactory.newTransformer();
    String path = PersonDaoImpl.class.getResource("/").getPath();// 获取项目根目录D:/workspace/8.12DomParseXml/bin/
    System.out.println(path);
    File file = new File(path + xmlPath);
    transform.transform(new DOMSource(document), new StreamResult(file));

  }

  /**
   * 根据省份证号码查询该用户信息；
   * */
  @Override
  public Person selectPersonByCardno(String cardno, String xmlPath)
      throws Exception {
    Person person = new Person();
    // 创建解析工厂
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory
        .newInstance();
    // 创建解析器
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    InputStream inputStream = PersonDaoImpl.class.getClassLoader()
        .getResourceAsStream(xmlPath);
    Document document = builder.parse(inputStream);// 通过parse解析，输入流，返回文本对象；
    Element root = document.getDocumentElement();// 获取根节点；persons标签节点；
    NodeList nodeList = root.getElementsByTagName("person");
    if (cardno != null && !cardno.equals("")){
      for (int i = 0; i < nodeList.getLength(); i++){
        Element personElement = (Element) nodeList.item(i);// person节点；
        if (cardno.equals(personElement.getAttribute("cardno"))){
          person.setName(personElement.getElementsByTagName("name").item(0)
              .getNodeValue());
          person.setAge(Integer.parseInt(personElement
              .getElementsByTagName("age").item(0).getNodeValue()));
          person.setAddress(personElement.getElementsByTagName("address")
              .item(0).getNodeValue());
          person.setCardno(cardno);
          person.setBirthday(personElement.getElementsByTagName("birthday")
              .item(0).getNodeValue());
        }
      }
    }

    return person;
  }

  /**
   * 登陆： 用户名为cardno， 密码默认为：cardno后三位
   * */
  public Boolean login(String username, String pwd, String xmlPath)
      throws Exception {

    // 如果用户名密码为空，登录失败；
    if (username == null || pwd == null || username.trim().equals("")
        || pwd.trim().equals("")){
      return false;
    }

    // 创建解析工厂
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory
        .newInstance();
    // 创建解析器
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    InputStream inputStream = PersonDaoImpl.class.getClassLoader()
        .getResourceAsStream(xmlPath);
    Document document = builder.parse(inputStream);// 通过parse解析，输入流，返回文本对象；
    Element root = document.getDocumentElement();// 获取根节点；persons标签节点；
    NodeList nodeList = root.getElementsByTagName("person");
    for (int i = 0; i < nodeList.getLength(); i++){
      Element personElement = (Element) nodeList.item(i);
      String cardno = personElement.getAttribute("cardno");
      if (username.equals(cardno)
          && pwd.equals(cardno.substring(cardno.length() - 3))){
        return true;

      }
    }

    return false;
  }

  public static void main(String args[]) {
    String username = "123456";
    System.out.println(username.substring(username.length() - 3));
  }

}
