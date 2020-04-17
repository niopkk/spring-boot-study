package com.bbz.ioc.step05;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface BeanDefinitionReader {

    void loadBeanDefinitions(String local) throws Exception;
}
