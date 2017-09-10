import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by java2 on 07.09.17.
 */
public class Main {

    public static void main(String[] args) {
        ReadParamXML paramXML = new ReadParamXML();
        ScanDirReadJSON readJSON = new ScanDirReadJSON();

        try {

            paramXML.getDataFromXML("D:\\myjava\\com.hillel.core\\Quiz_07_09\\src\\conf.xml");
            System.out.println(paramXML.getPath());
            System.out.println(paramXML.getFileExt());

            readJSON.scanDir(paramXML.getPath(), paramXML.getFileExt());
            System.out.println(readJSON.lowercase + " " + readJSON.uppercase);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
