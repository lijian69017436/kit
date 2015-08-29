package saxParseXML;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


public class TextSaxParseXml {

	public static  List<Person> loadParseXmlBySax(String xmlPath) throws ParserConfigurationException, SAXException, IOException{
		SAXParserFactory saxFactory= SAXParserFactory.newInstance();//ʵ���������
		SAXParser saxParser=saxFactory.newSAXParser();
		InputStream inputStream=TextSaxParseXml.class.getClassLoader().getResourceAsStream(xmlPath);
		SAXHander saxHander=new SAXHander();
		saxParser.parse(inputStream, saxHander);
		
		return saxHander.getPersonList();
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
	List<Person> list=	loadParseXmlBySax("person.xml");
	for(Person p:list){
		System.out.println(p.getCardno()+":"+p.getAge()+":"+p.getName()+":"+p.getAddress());
	}
	}

}
