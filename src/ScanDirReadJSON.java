import java.io.*;
import java.util.ArrayList;

/**
 * Created by java2 on 07.09.17.
 */
public class ScanDirReadJSON {



    //    public String path;
//  public String fileExt;
    public String[] words;
    public String uppercase;
    public String lowercase;

//    public void getPathAndExt(ArrayList<String> list) {
//        list = paramXML.getDirExt();
//        for (int i = 0; i < list.size(); i++) {
//            path = list.get(0);
//            fileExt = list.get(1);
//        }
//    }

    public void scanDir(String dir, String ext) throws FileNotFoundException {
        ReadParamXML paramXML = new ReadParamXML();
        BufferedReader reader = new BufferedReader(new FileReader(paramXML.getPath()));
        File directory = new File(dir);
        File[] fList = directory.listFiles();

        for (File file : fList) {
            if (file.isFile()) {
                if (file.getAbsolutePath().endsWith(paramXML.getFileExt())) {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
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