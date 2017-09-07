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

    File getFile = new File("/home/java2/IdeaProjects/Quiz_2/quiz/src/conf.xml");
    ArrayList<String> dirExt = new ArrayList<>();
    String path;
    String fileExt;

    public ArrayList<String> getDataFromXML() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFact.newDocumentBuilder();
        Document doc = dBuilder.parse(getFile);
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

                dirExt.add(0, path);
                dirExt.add(0, fileExt);
            }
        }

        return dirExt;
    }
}