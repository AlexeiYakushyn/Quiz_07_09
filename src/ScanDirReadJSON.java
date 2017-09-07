import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by java2 on 07.09.17.
 */
public class ScanDirReadJSON {

    String path;
    String fileExt;


    public void getPathAndExt(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            path = list.get(0);
            fileExt = list.get(1);
        }
    }

    public void scanDir(String dir, String ext) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        File directory = new File(dir);
        File[] fList = directory.listFiles();

        for (File file : fList) {
            if (file.isFile()) {
                if (file.getAbsolutePath().endsWith(".txt")) {

                }
            }
        }
    }
}