import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by java2 on 07.09.17.
 */

public class ReadParamXML {

    private String path;
    private String fileExt;


    public ReadParamXML(String path, String fileExt) {
        this.path = path;
        this.fileExt = fileExt;
    }

    public ReadParamXML() {

    }

    public ReadParamXML getDataFromXML(String filePath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFact.newDocumentBuilder();
        Document doc = dBuilder.parse(filePath);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("configuration");

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node nList = nodeList.item(i);

            if (nList.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) nList;

                path = element
                        .getElementsByTagName("directory")
                        .item(0)
                        .getTextContent();

                fileExt = element
                        .getElementsByTagName("extension")
                        .item(0)
                        .getTextContent();
            }
        }
        return new ReadParamXML(path, fileExt);
    }

    public String getPath() {
        return path;
    }

    public String getFileExt() {
        return fileExt;
    }
}
