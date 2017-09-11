import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alexei.yakushyn on 11.09.2017.
 */
public class CreateJSON {

    public void createJSONFile(ArrayList<String> up, ArrayList<String> low) {

        up = new ArrayList<String>();
        low = new ArrayList<String>();
        for (int i = 0; i < up.size(); i++) {
            System.out.println(up.get(i));
        }

        JSONObject obj = new JSONObject();
        JSONArray uppercase = new JSONArray();
        JSONArray lowercase = new JSONArray();

        uppercase.addAll(up);
        lowercase.addAll(low);

        obj.put("uppercase", uppercase);
        obj.put("lowercase", lowercase);

        try {
            FileWriter file = new FileWriter("E:\\ProgrammFiles\\hillel\\Quiz_07_09\\src\\output.json");
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(obj);
    }
}
