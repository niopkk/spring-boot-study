package com.bbz.ioc.step04.xml;

import com.bbz.ioc.step04.AbstracBeanDefinitionReader;
import com.bbz.ioc.step04.BeanDefinition;
import com.bbz.ioc.step04.PropertyValue;
import com.bbz.ioc.step04.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;


public class XmlBeanDefinitionReader extends AbstracBeanDefinitionReader {


    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String local) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(local).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(inputStream);

        //解析doc
        registerBeanDifinitions(doc);

        //关闭流
        inputStream.close();
    }

    private void registerBeanDifinitions(Document doc) {

        Element root = doc.getDocumentElement();

        parseBeanDefinitions(root);

    }

    private void parseBeanDefinitions(Element root) {
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    private void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("id");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processPropertyValue(ele, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
    }

    private void processPropertyValue(Element ele, BeanDefinition beanDefinition) {
        NodeList propertyNode = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                beanDefinition.getPropertyValues().addProperValues(new PropertyValue(name, value));
            }
        }
    }
}
