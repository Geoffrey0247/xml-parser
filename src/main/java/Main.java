import org.xml.sax.SAXException;
import parser.XMLParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by GBC on 2016/12/15.
 */
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        XMLParser.parser("刑事一审");
    }
}