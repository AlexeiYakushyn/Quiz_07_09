import java.io.*;
import java.util.ArrayList;

/**
 * Created by java2 on 07.09.17.
 */
public class ScanDirRead {

    private ArrayList<String> words;

    public ArrayList<String> getWords() {
        return words;
    }

    public void scanDir(String dir, String ext) throws FileNotFoundException {
        ReadParamXML paramXML = new ReadParamXML();
        File directory = new File(dir);
        File[] fList = directory.listFiles();
        words = new ArrayList<String>();

        for (int j = 0; j < fList.length; j++) {
            if (fList[j].isFile()) {
                if (fList[j].getAbsolutePath().endsWith(ext)) {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(fList[j]));
                        String ln = null;
                        while ((ln = br.readLine()) != null) {
                            words.add(ln);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}