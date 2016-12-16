package parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
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
    public static void parser(String filesPath)throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
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
            Element root=xmldoc.getDocumentElement();
            Element ZJJL = (Element)XMLUtil.selectSingleNode("//ZJJL",root);
            if(ZJJL==null){
                continue;
            }else {
                Element ZZQK = xmldoc.createElement("ZZQK");
                ZZQK.setAttribute("nameCN","质证情况");
                Element SFCX = xmldoc.createElement("SFCX");
                SFCX.setAttribute("nameCN","是否采信");
                SFCX.setAttribute("value","是");
                Element ZZLY = xmldoc.createElement("ZZLY");
                ZZLY.setAttribute("nameCN","质证理由");
                ZZLY.setAttribute("value","理由如下");
                ZZQK.appendChild(SFCX);
                ZZQK.appendChild(ZZLY);

                ZJJL.appendChild(ZZQK);
                XMLUtil.saveXml(XMLUtil.outPath+filesPath+"\\"+filename,xmldoc);
                count++;
            }

        }
        System.out.println("xml parse: "+count+"/"+filenames.length);
    }
}
