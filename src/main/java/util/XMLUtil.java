package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.*;
import javax.xml.xpath.*;

/**
 * Created by GBC on 2016/12/16.
 */
public class  XMLUtil{
    public static String readPath = "src/main/resources/in/";
    public static String outPath = "src/main/resources/out/";

    public static void output(Node node) {//将node的XML字符串输出到控制台
        TransformerFactory transFactory=TransformerFactory.newInstance();
        try {
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty("encoding", "utf-8");
            transformer.setOutputProperty("indent", "yes");
            DOMSource source=new DOMSource();
            source.setNode(node);
            StreamResult result=new StreamResult();
            result.setOutputStream(System.out);

            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static Node selectSingleNode(String express, Object source) {//查找节点，并返回第一个符合条件节点
        Node result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(Node) xpath.evaluate(express, source, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static NodeList selectNodes(String express, Object source) {//查找节点，返回符合条件的节点集。
        NodeList result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(NodeList) xpath.evaluate(express, source, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void saveXml(String fileName, Document doc) {//将Document输出到文件
        TransformerFactory transFactory=TransformerFactory.newInstance();
        try {
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            DOMSource source=new DOMSource();
            source.setNode(doc);
            StreamResult result=new StreamResult();
            result.setOutputStream(new FileOutputStream(fileName));

            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        try {
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder db=factory.newDocumentBuilder();
            Document xmldoc=db.parse(new File(XMLUtil.readPath+"\\刑事一审\\110.xml"));
            Element root=xmldoc.getDocumentElement();


//            Element E_A = (Element)selectSingleNode("/A",root);
//            Element E_B = xmldoc.createElement("B");
//            E_B.setAttribute("nameCN","bbb");
//            E_B.setAttribute("value","value");
//            E_A.appendChild(E_B);
            Element e = (Element)selectSingleNode("//ZJJL",root);
            System.out.println(e.getAttribute("value"));


            //saveXml(XMLUtil.outPath+"a.xml", xmldoc);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
