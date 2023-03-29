package com.minis.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

public class ClassPathXmlResource implements Resource {

    Document document;
    Element rootElement;
    Iterator elementIterator;

    public ClassPathXmlResource(String fileName) {
        SAXReader saxReader = new SAXReader();
        try {
            URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
            Document document = saxReader.read(xmlPath);
            Element rootElement = document.getRootElement(); //对配置文件中的每一个，进行处理
            this.elementIterator = this.rootElement.elementIterator();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public boolean hasNext() {
        return this.elementIterator.hasNext();
    }

    public Object next() {
        return this.elementIterator.next();
    }
}
