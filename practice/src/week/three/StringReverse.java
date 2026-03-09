package week.three;

public class StringReverse {
    public static void main(String[] args) {
        String str = "backend";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length/2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = temp;
        }
        str = new String(charArray);
        System.out.println(str);
    }
}
