package week.four;

public class CountVowels {
    public static void main(String[] args) {
        String str = "Java is powerful";
        System.out.println(countVowels(str));
    }
    static int countVowels(String s){
        int count = 0;
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i'  || arr[i] == 'o' || arr[i] == 'u') {
                count++;
            }
        }
        return count;
    }
}
