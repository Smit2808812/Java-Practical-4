import java.util.regex.*;

public class TemplateFiller {

    public static void main(String[] args) {

        String template = "Dear {name}, order {id} ships {date}.";

        String[] names = {"name", "id"};
        String[] values = {"Riya", "A07"};

        Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
        Matcher matcher = pattern.matcher(template);

        StringBuilder out = new StringBuilder();

        int last = 0;

        while (matcher.find()) {

            out.append(template, last, matcher.start());

            String key = matcher.group(1);

            String replacement = "[?]";

            for (int i = 0; i < names.length; i++) {

                if (names[i].equals(key)) {
                    replacement = values[i];
                    break;
                }
            }

            out.append(replacement);

            last = matcher.end();
        }

        out.append(template.substring(last));

        System.out.println(out);
    }
}
   
