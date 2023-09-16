package at.ac.htlinn.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TEST {


    public static void main(String[] args) {
        String s = "import java.util.ArrayList;\n" +
                "import java.util.regex.Matcher;\n" +
                "import java.util.regex.Pattern;";

        ArrayList<String> classNames = extractClassNames(s);
        System.out.println(classNames);

    }

    public static ArrayList<String> extractClassNames(String input) {
        String pattern = "\\s*import\\s+([a-zA-Z0-9_.]*)\\s*;";
        ArrayList<String> classNames = new ArrayList<>();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        while (m.find()) {
            String s = m.group();
            s = s.replace("import", "");
            s = s.replace(";", "");
            s = s.replace(" ", "");
            String[] strings = s.split("\\.");
            s = strings[strings.length - 1];
            classNames.add(s);
        }

        return classNames;
    }


}
