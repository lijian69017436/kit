package com.zbxsoft.core.mapper;

import com.zbxsoft.core.utils.ExceptionUtils;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.namespace.QName;
import org.apache.commons.lang.StringUtils;

/**
 * 对象转换胃 xml 
 * @author Administrator
 *
 */
public class JaxbMapper {
	private JAXBContext jaxbContext;

	public JaxbMapper(Class<?>[] rootTypes) {
		try {
			this.jaxbContext = JAXBContext.newInstance(rootTypes);
		} catch (JAXBException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public String toXml(Object root) {
		return toXml(root, null);
	}

	public String toXml(Object root, String encoding) {
		try {
			StringWriter writer = new StringWriter();
			createMarshaller(encoding).marshal(root, writer);
			return writer.toString();
		} catch (JAXBException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public String toXml(Collection<?> root, String rootName) {
		return toXml(root, rootName, null);
	}

	public String toXml(Collection<?> root, String rootName, String encoding) {
		try {
			CollectionWrapper wrapper = new CollectionWrapper();
			wrapper.collection = root;

			JAXBElement wrapperElement = new JAXBElement(new QName(rootName), CollectionWrapper.class, wrapper);

			StringWriter writer = new StringWriter();
			createMarshaller(encoding).marshal(wrapperElement, writer);

			return writer.toString();
		} catch (JAXBException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public <T> T fromXml(String xml) {
		try {
			StringReader reader = new StringReader(xml);
			return (T) createUnmarshaller().unmarshal(reader);
		} catch (JAXBException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public Marshaller createMarshaller(String encoding) {
		try {
			Marshaller marshaller = this.jaxbContext.createMarshaller();

			marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);

			if (StringUtils.isNotBlank(encoding)) {
				marshaller.setProperty("jaxb.encoding", encoding);
			}

			return marshaller;
		} catch (JAXBException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public Unmarshaller createUnmarshaller() {
		try {
			return this.jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public static class CollectionWrapper {

		@XmlAnyElement
		protected Collection<?> collection;
	}
}
