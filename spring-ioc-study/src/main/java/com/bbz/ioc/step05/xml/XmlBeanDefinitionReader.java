package com.bbz.ioc.step05.xml;

import com.bbz.ioc.step05.AbstracBeanDefinitionReader;
import com.bbz.ioc.step05.BeanDefinition;
import com.bbz.ioc.step05.BeanRefernce;
import com.bbz.ioc.step05.PropertyValue;
import com.bbz.ioc.step05.io.ResourceLoader;
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
    public void loadBeanDefinitions(String local) throws IOException, ParserConfigurationException, SAXException {
        InputStream inputStream = getResourceLoader().getResource(local).getInputStream();

        doLoadBeanDefinitions(inputStream);

    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(inputStream);

        //解析beandefinition
        registerBeanDefinitions(doc);

        inputStream.close();
    }

    private void registerBeanDefinitions(Document doc) {

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

        String id = ele.getAttribute("id");
        String className = ele.getAttribute("class");

        BeanDefinition beanDefinition = new BeanDefinition();

        processProperValue(ele, beanDefinition);

        beanDefinition.setBeanClassName(className);


        getRegisty().put(id, beanDefinition);

    }

    private void processProperValue(Element ele, BeanDefinition beanDefinition) {
        NodeList property = ele.getElementsByTagName("property");
        for (int i = 0; i < property.getLength(); i++) {
            Node node = property.item(i);
            if (node instanceof Element) {
                Element el = (Element) node;
                String name = el.getAttribute("name");
                String value = el.getAttribute("value");

                if (value != null && value.length() > 0) {
                    beanDefinition.getPropertyValues().addPropertyValues(new PropertyValue(name, value));
                } else {
                    String ref = el.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    }
                    BeanRefernce beanRefernce = new BeanRefernce(ref);
                    beanDefinition.getPropertyValues().addPropertyValues(new PropertyValue(name, beanRefernce));
                }


            }
        }
    }
}
