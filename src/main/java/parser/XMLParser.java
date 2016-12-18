package parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import strategy.ZZStrategy;
import util.XMLUtil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;

/**
 * Created by GBC on 2016/12/16.
 */
public class XMLParser {
    public static void zzparser(String filesPath, ZZStrategy zzStrategy)throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        File file=new File(XMLUtil.readPath+filesPath);
        String filenames[];
        filenames = file.list();
        int count = 0;

        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder db=factory.newDocumentBuilder();
        for (String filename: filenames) {
            //处理过程
            if (filename.charAt(0) == '.') continue;

            Document xmldoc=db.parse(new File(XMLUtil.readPath+filesPath+"\\"+filename));

            Document result_doc = zzStrategy.addZZ(xmldoc);
            XMLUtil.saveXml(XMLUtil.outPath+filesPath+"\\"+filename,result_doc);
            count++;
        }
        System.out.println("xml parse: "+count+"/"+filenames.length);
    }
}
