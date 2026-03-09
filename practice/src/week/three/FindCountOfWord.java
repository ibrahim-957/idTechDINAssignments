package week.three;

public class FindCountOfWord {

    public static void main(String[] args) {

        String str = "Java is very powerful";

        int count = 0;
        boolean inWord = false;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != ' ' && !inWord) {
                count++;
                inWord = true;
            } else if (str.charAt(i) == ' ') {
                inWord = false;
            }
        }

        System.out.println("Word count = " + count);
    }
}
