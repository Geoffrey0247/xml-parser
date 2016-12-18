import org.xml.sax.SAXException;
import parser.XMLParser;
import strategy.MSZZStrategy;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by GBC on 2016/12/15.
 */
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        XMLParser.zzparser("民事一审", new MSZZStrategy());
    }
}