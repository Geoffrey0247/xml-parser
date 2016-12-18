package strategy;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import util.XMLUtil;

/**
 * Created by GBC on 2016/12/18.
 */
public class MSZZStrategy implements ZZStrategy {

    public Document addZZ(Document xmldoc){
        Element root=xmldoc.getDocumentElement();
        Element ZJJL = (Element) XMLUtil.selectSingleNode("//ZJJL",root);
        if(ZJJL==null){
            return xmldoc;
        }else {
            Element ZZQK = xmldoc.createElement("ZZQK");
            ZZQK.setAttribute("nameCN", "质证情况");
            Element SFCX = xmldoc.createElement("SFCX");
            SFCX.setAttribute("nameCN", "是否采信");
            SFCX.setAttribute("value", "是");
            Element ZZLY = xmldoc.createElement("ZZLY");
            ZZLY.setAttribute("nameCN", "质证理由");
            ZZLY.setAttribute("value", "理由如下");
            ZZQK.appendChild(SFCX);
            ZZQK.appendChild(ZZLY);

            ZJJL.appendChild(ZZQK);
            return xmldoc;
        }
    }
}
