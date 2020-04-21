package com.bbz.ioc.step06.beans.xml;

import com.bbz.ioc.step06.beans.AbstarcBeanDefinitionReader;
import com.bbz.ioc.step06.beans.BeanDefinition;
import com.bbz.ioc.step06.BeanRefernce;
import com.bbz.ioc.step06.beans.PropertyValue;
import com.bbz.ioc.step06.beans.io.LoaderResource;
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

public class XmlBeanDefinitionReader extends AbstarcBeanDefinitionReader {


    public XmlBeanDefinitionReader(LoaderResource loaderResource) {
        super(loaderResource);
    }

    @Override
    public void loadBeanDefinitions(String local) throws Exception {
        InputStream inputStream = getLoaderResource().getResource(local).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(inputStream);


        registryBeanDefinitions(doc);

        inputStream.close();
    }

    private void registryBeanDefinitions(Document doc) {

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
        final String id = ele.getAttribute("id");
        final String className = ele.getAttribute("class");

        BeanDefinition beanDefinition = new BeanDefinition();

        processProperValue(ele, beanDefinition);

        beanDefinition.setClassBeanName(className);

        getRegistry().put(id, beanDefinition);

    }

    private void processProperValue(Element ele, BeanDefinition beanDefinition) {
        NodeList property = ele.getElementsByTagName("property");
        for (int i = 0; i < property.getLength(); i++) {
            Node item = property.item(i);
            if (item instanceof Element) {
                Element el = (Element) item;
                String name = el.getAttribute("name");
                String value = el.getAttribute("value");

                if (value != null && value.length() > 0) {
                    beanDefinition.getPropertyValues().addPropertyValues(new PropertyValue(name, value));
                } else {
                    String ref = el.getAttribute("ref");
                    if (ref != null && ref.length() == 0) {
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
