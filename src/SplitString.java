import java.util.ArrayList;

/**
 * Created by alexei.yakushyn on 11.09.2017.
 */
public class SplitString {

    private ArrayList<String> uppercase;
    private ArrayList<String> lowercase;

    public ArrayList<String> getUppercase() {
        return uppercase;
    }

    public ArrayList<String> getLowercase() {
        return lowercase;
    }

    public void splitStrings(ArrayList<String> list) {
        uppercase = new ArrayList<String>();
        lowercase = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            String[] words = list.get(i).split(" ");

            for (int j = 0; j < words.length; j++) {
                if (Character.isUpperCase(words[j].charAt(0))) {
                    uppercase.add(words[j]);
                } else lowercase.add(words[j]);
            }
        }
    }
}
