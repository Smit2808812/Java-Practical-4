public class PasswordChecker {

    static String strength(String pw) {

        int score = 0;

        boolean length = pw.length() >= 8;
        boolean upper = pw.matches(".*[A-Z].*");
        boolean digit = pw.matches(".*[0-9].*");
        boolean special = pw.matches(".*[^A-Za-z0-9].*");

        System.out.println("Password: " + pw);

        System.out.println("Length: " + length
                + ", Uppercase: " + upper
                + ", Digit: " + digit
                + ", Special: " + special);

        if (length) {
            score++;
        }

        if (upper) {
            score++;
        }

        if (digit) {
            score++;
        }

        if (special) {
            score++;
        }

        return score <= 1 ? "Weak"
                : score <= 3 ? "Medium"
                : "Strong";
    }

    public static void main(String[] args) {

        for (String p : new String[]{
                "abc",
                "abcdef12",
                "Abcd1234!",
                "HELLO123"
        }) {

            System.out.println("Strength: " + strength(p) + "\n");
        }
    }
}
