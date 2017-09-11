import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by java2 on 07.09.17.
 */
public class Main {

    public static void main(String[] args) {
        ReadParamXML paramXML = new ReadParamXML();
        ScanDirRead readJSON = new ScanDirRead();
        SplitString jsn = new SplitString();
        CreateJSON json = new CreateJSON();


        try {
            paramXML.getDataFromXML("E:\\ProgrammFiles\\hillel\\Quiz_07_09\\src\\conf.xml");
            System.out.println(paramXML.getPath());
            System.out.println(paramXML.getFileExt());

            readJSON.scanDir(paramXML.getPath(), paramXML.getFileExt());
            System.out.println(readJSON.getWords());
            jsn.splitStrings(readJSON.getWords());
            //System.out.println(jsn.getUppercase() + " " + jsn.getLowercase());
            json.createJSONFile(jsn.getUppercase(), jsn.getLowercase());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
