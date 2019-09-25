package com.javarush.task.task33.task3309;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        StringWriter writer = new StringWriter();

        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Получение фабрики, чтобы после получить билдер документов.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //factory.setCoalescing(true);   // specifies that parser produced by this code will convert CDATA nodes to text

            // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
            Document document = builder.newDocument();
            marshaller.marshal(obj, document);

            // Получение списка всех элементов.
            NodeList nodeList = document.getElementsByTagName("*");
            if (nodeList.getLength()>0) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeName().equals(tagName)) {
                        node.getParentNode().insertBefore(document.createComment(comment), node);
                    }

                    if (node.getFirstChild().getNodeType() == Node.TEXT_NODE) {
                        Node currentNode = node.getFirstChild();
                        if (currentNode.getTextContent().matches(".*[<>&\'\"].*")) {
                            String content = currentNode.getTextContent();
                            CDATASection cdataSection = document.createCDATASection(content);
                            node.replaceChild(cdataSection, currentNode);
                        }
                    }
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");


            transformer.transform(new DOMSource(document), new StreamResult(writer));
        } catch (JAXBException | TransformerException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        return writer.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Solution.toXmlWithComment(new First(), "second", "it's a comment"));
    }

    @XmlRootElement(name = "first")
    public static class First {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
        @XmlElement(name = "second")
        public String item3 = "";
        @XmlElement(name = "third")
        public String item4;
        @XmlElement(name = "forth")
        public Second[] third = new Second[]{new Second()};
        @XmlElement(name = "fifth")
        public String item5 = "need CDATA because of \"";
    }

    public static class Second {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
    }
}
