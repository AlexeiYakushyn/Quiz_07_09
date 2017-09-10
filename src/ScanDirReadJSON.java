import java.io.*;
import java.util.ArrayList;

/**
 * Created by java2 on 07.09.17.
 */
public class ScanDirReadJSON {

    public String[] words;
    public String uppercase;
    public String lowercase;

    public void scanDir(String dir, String ext) throws FileNotFoundException {
        ReadParamXML paramXML = new ReadParamXML();
        File directory = new File(dir);
        File[] fList = directory.listFiles();

        for (int j = 0; j < fList.length; j++) {
            if (fList[j].isFile()) {
                if (fList[j].getAbsolutePath().endsWith(ext)) {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(fList[j]));
                        String ln = null;
                        while ((ln = br.readLine()) != null) {
                            words = ln.split(" ");
                            for (int i = 0; i < words.length; i++) {
                                if (words[i].equals(words[i].toLowerCase())) {
                                    lowercase = words[i];
                                } else uppercase = words[i];
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}