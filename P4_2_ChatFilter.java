   import java.util.Scanner;

public class ChatFilter {

    public static void main(String[] args) {

        String[] logs = {
            "10:05 alice Hello there",
            "10:06 bob Good morning",
            "broken line",
            "10:07 cara HELLO everyone"
        };

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Keyword: ");

            String key = sc.nextLine().toLowerCase();

            int matches = 0;

            StringBuilder report = new StringBuilder();

            for (String line : logs) {

                String[] p = line.split(" ", 3);

                if (p.length < 3) {
                    continue;
                }

                if (p[2].toLowerCase().contains(key)) {

                    matches++;

                    report.append(p[0])
                          .append(" ")
                          .append(p[1])
                          .append(": ")
                          .append(p[2])
                          .append('\n');
                }
            }

            System.out.println("Matches: " + matches);

            System.out.print(report);
        }
    }
}
