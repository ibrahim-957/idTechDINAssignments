package week.three;

public class MostLengthWordFromSentence {
    public static void main(String[] args) {
        String str = "Java is very powerful language";
        String[] words = str.split(" ");
        String longestWord = "";
        for (String word : words) {
            String cleanedWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanedWord.length() > longestWord.length()) {
                longestWord = cleanedWord;
            }
        }
        System.out.println("Longest word: " + longestWord);
    }
}

