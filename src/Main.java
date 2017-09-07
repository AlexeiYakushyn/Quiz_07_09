import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by java2 on 07.09.17.
 */
public class Main {

    public static void main(String[] args) {
        ReadParamXML paramXML = new ReadParamXML();
        ScanDirReadJSON readJSON = new ScanDirReadJSON();

        try {

            readJSON.getPathAndExt(paramXML.getDataFromXML());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        System.out.println((readJSON.path + " " + readJSON.fileExt));

    }
}
