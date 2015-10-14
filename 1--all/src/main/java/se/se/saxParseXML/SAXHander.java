package se.se.saxParseXML;

import java.util.ArrayList;
import java.util.List;




import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 笔试题面试题+上机试题：解析xml（笔试题写代码）
 * XML的解析方式：
 * 1. SAX解析： JDK自带的；特点：事件驱动、一边加载一边解析、解析XML文件效率高，但是不灵活；
 * 2.DOM 解析： JDK自带的；特点：通过树型结构方式解析数据，加载完整个xml文件后，在解析xml文件；灵活；
 * 3.第三方解析方式：DOM4j
 *
 * sax解析：
 * xml加载时 默认执行一个事件；
 * 遇到一个开始节点 执行一个事件；
 * 该节点结束 执行一个事件；
 * 如果获取指定属性或者文本或者节点名，默认也会执行一个事件；
 * xml加载完毕，执行一个事件； 
 **/
//作为解析器使用；重写DefaultHandler类中相关方法；实现事件驱动，定义我们需要的解析过程；
public class SAXHander extends DefaultHandler{
      private   List<Person> list=new ArrayList<Person>();//定义存储Person对象的list集合；
      Person person=null;
      String tagName="";//用于暂时存储节点名称
	/*
	 * xml文件加载时指定的方法；
	 * */
	public void startDocument() throws SAXException {
		 System.out.println("XML文件开始加载");
	}
	
	//解析过程中，遇到指定元素（开始节点）；
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attribute) throws SAXException {// qName 参数表示标签名，attribute 表示该标签属性
		 if(qName.equals("person")){//如果开始节点为person
			person= new Person();//实例化Person对象
			String cardno=attribute.getValue("cardno");//获取person节点的cardno属性值；
			person.setCardno(cardno);
		 }
		 tagName=qName;
		 
	}
	
	//该方法用于获取指定标签文本信息，以ch参数这个数组暂时存储数据；
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String textVal=new String(ch,start,length);
		 if(tagName.equals("name")){
			 person.setName(textVal);//获取name 
		 }
		 if(tagName.equals("age")){
			 person.setAge(Integer.parseInt(textVal));		 
		 }
		 if(tagName.equals("address")){
			 person.setAddress(textVal);
		 }
		 
	}

	//解析过程中，遇到指定元素（结束节点）；
	@Override
	public void endElement(String uri, String localName, String qname)
			throws SAXException {
		tagName="";
		if(qname.equals("person")){
			list.add(person);
		}
		
		
	}
	/*
	 * 文本加载完毕后执行的方法；
	 * */
	@Override
	public void endDocument() throws SAXException {
		 System.out.println("文件加载完毕，解析完成！");
	}
	
	public List<Person> getPersonList(){
		return this.list;
	}

}